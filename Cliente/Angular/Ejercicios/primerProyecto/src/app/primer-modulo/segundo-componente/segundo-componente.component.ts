import { Component, OnInit } from '@angular/core';
import { PreguntasInterface } from './PreguntasInterface';


@Component({
  selector: 'app-segundo-componente',
  templateUrl: './segundo-componente.component.html',
  styleUrls: ['./segundo-componente.component.css']
})
export class SegundoComponenteComponent implements OnInit {

  

  preguntasObj = [
    {
      pregunta: "¿España ganará la Euro 2016?",
      si: 22,
      no: 95
    },
    {
      pregunta: "¿Estás aprendiendo Angular 2 en DesarrolloWeb?",
      si: 262,
      no: 3
    },
    {
      pregunta: "¿Has hecho ya algún curso en EscuelaIT?",
      si: 1026,
      no: 1
    }
  ]

  preguntasObj2: PreguntasInterface[] = [
    {
      pregunta: "¿Te gusta usar interfaces?",
      si: 72,
      no: 6
    }
]



  constructor() { }

  ngOnInit(): void {
  }

}
