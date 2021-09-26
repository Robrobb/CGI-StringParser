import * as React from 'react';


interface IProps {
  title:string,
  body:string,
  children:React.ReactNode
}

export default function Column(props: IProps) {

  return (
    <div className="col-sm-4">
    <h3>{props.title}</h3>
    <p>{props.body}</p>
    {props.children}
  </div>

  );
}
