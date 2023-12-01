import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cuadrado',
  templateUrl: './cuadrado.component.html',
  styleUrls: ['./cuadrado.component.css']
})
export class CuadradoComponent implements OnInit {

  lado = 4;

  cambiaLado(valor:number) {
    this.lado = valor;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
