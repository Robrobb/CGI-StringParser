import * as React from 'react';


interface IProps {
  title:string,
  body:string
}

export default function Jumbotron(props: IProps) {

  return (
    <div className="jumbotron text-center blue">
    <h1>{props.title}</h1>
    <p>{props.body}</p>
  </div>
  );
}
