import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prueba-ng-model',
  templateUrl: './prueba-ng-model.component.html',
  styleUrls: ['./prueba-ng-model.component.css']
})
export class PruebaNgModelComponent implements OnInit {
  lado = 1;

  cambiaLado(valor:number) {
    console.log("Lado cambia de: "+this.lado+" a "+valor);
    this.lado = valor;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
