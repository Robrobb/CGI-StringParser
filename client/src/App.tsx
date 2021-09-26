import React from 'react';
import './App.css';
import TextFieldComp from './Components/TextFieldComp';

import { Button } from '@mui/material';
import axios from 'axios';

interface IProps {
  text?: string;
  answer?: string[];

}

function App(this: any, props: IProps) {

  const [state, setState] = React.useState({
    answer: props.answer,
    text: props.text,
  });

  const changeState = (event: React.ChangeEvent<{ name?: string; value: unknown }>) => {
    const name = event.target.name as keyof typeof state;
    setState({ ...state, [name]: event.target.value });
  }
  const handlePost = () => {
      
      axios('http://localhost:8081/parser', {
        method: 'POST',
        data: {
        text: state.text,
      },
    }).then(response => response.data).then((data) => setState({ ...state, answer: data }));
  }


  return (
    <div className="App">

      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

      <div className="jumbotron text-center blue">
        <h1>WordCounter</h1>
        <p>Skriv en text och se dom mest använda orden</p>
      </div>

      <div className="container">
        <div className="row">
          <div className="col-sm-4">
            <h3>Steg ett</h3>
            <p>Skriv in text</p>
            <TextFieldComp handleChange={changeState.bind(this)}></TextFieldComp>
          </div>
          <div className="col-sm-4">
            <h3>Steg två</h3>
            <p>tryck på knappen för att dela upp</p>
            <Button variant="outlined" onClick={() => {
              handlePost();
            }}>Dela upp</Button>
          </div>
          <div className="col-sm-4">
            <h3>Resultat</h3>
            <p>se dom top 10 använda orden</p>
            {state.answer?.map((word:string) => { return <h4 key={word}>{word}</h4> })}
          </div>
        </div>
      </div>
    </div>


  );
}

export default App;
