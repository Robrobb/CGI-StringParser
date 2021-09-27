import React, { useEffect } from 'react';
import './App.css';
import TextFieldComp from './Components/TextFieldComp';
import { Alert, Button } from '@mui/material';
import axios from 'axios';
import Jumbotron from './Components/Jumbotron';
import Column from './Components/Column';

function App(this: any) {
  const [userText, setUserText] = React.useState<string>()
  const [response, setResponse] = React.useState<string[]>([])
  const [error, setError] = React.useState<boolean>(false)
  const [errorMessage, setErrorMessage] = React.useState<string>("")

  const changeState = (event: React.ChangeEvent<{ name?: string; value: unknown }>) => {
    setUserText(event.target.value as string)
  }
  const handlePost = () => {
    axios('http://localhost:8081/parser', {
      method: 'POST',
      data: {
        text: userText,
      },
    }).then((response) => {
      if (response.data.length) {
        handleSuccsess(response.data)
      } else {
        handleError("Inga ord hittades");
      }
    }).catch((error) => {
      //https://github.com/axios/axios#handling-errors länk till axios fel hantering
      if (error.response) {
        if (error.response.status == 500) {
          handleError("Server fel")
        }
        if (error.response.status == 400) {
          handleError("Inputfel")
        }} else if (error.request) {
        handleError("Får inget svar från servern")
      } else {
        handleError("Okänt fel, går ej att skicka din begäran")
      }
    })}

  const handleSuccsess = (response: string[]) => {
    setResponse(response);
    setError(false);
  }

  const handleError = (message: string) => {
    setError(true)
    setErrorMessage(message)
  }

  return (
    <div className="App">

      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

      <Jumbotron title={'WordCounter'} body={'Skriv en text och se dom mest använda orden'} />
      <div className="container">
        <div className="row">

          <Column title="Steg ett" body="Skriv in tex">
            <TextFieldComp handleChange={changeState.bind(this)}></TextFieldComp>
          </Column>

          <Column title="Steg två" body="tryck på knappen för att dela upp">
            <Button variant="outlined" onClick={() => {
              handlePost();
            }}>Dela upp</Button>
          </Column>

          <Column title="Resultat" body="se dom top 10 använda orden">
            {!error && response.map((word: string) => { return <h4 key={word}>{word}</h4> })}
            {error && <Alert severity="error">{errorMessage}</Alert>}
          </Column>
        </div>
      </div>
    </div>);
}

export default App;
