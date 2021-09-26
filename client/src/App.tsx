import React from 'react';
import './App.css';
import TextFieldComp from './Components/TextFieldComp';

import { Button } from '@mui/material';
import axios from 'axios';
import { Statement } from 'typescript';
import ErrorModal from './Components/ErrorModal';


interface IProps {
  text?: string;
  answer?: string[];
  errorMessage?:string;
  openError?:boolean;
}

function App(this: any, props: IProps) {

  const [state, setState] = React.useState({
    answer: props.answer,
    text: props.text,
    errorMessage:props.errorMessage,
    openError:props.openError
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
    }).then((response) => {

      console.log(response.status)

      if(response.data.length){
        setState({ ...state, answer: response.data })
        
        }else{
        handleError("Inga ord hittades");
      }
    }
    ).catch((error)=>{
      //https://github.com/axios/axios#handling-errors länk till axios fel hantering
      if (error.response) {
        if(error.response.status==500){
          handleError("Server fel")
        }
        if(error.response.status==400){
          handleError("Inputfel")
        }
  
      } else if (error.request) {
        
          handleError("Får inget svar från servern")
       
        
      }else{
          handleError("Okänt fel, går ej att skicka din begäran")
      }
    })
  }
  //

  const handleSuccsess=(response:IProps)=>{
    setState({ ...state, answer: response.answer })
  }

  const handleError=(response:any)=>{

    setState({ ...state, openError: true })
    setState({ ...state, errorMessage: "ett fel inträffade, inga ord funna" })

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
            {state.openError && <ErrorModal open={props.openError as boolean} message={props.errorMessage as string}></ErrorModal>}
          </div>
        </div>
      </div>
      
    </div>


  );
}

export default App;
