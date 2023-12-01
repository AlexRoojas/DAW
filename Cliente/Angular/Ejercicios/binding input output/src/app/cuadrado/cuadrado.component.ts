import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cuadrado',
  templateUrl: './cuadrado.component.html',
  styleUrls: ['./cuadrado.component.css']
})
export class CuadradoComponent implements OnInit {
  @Input()//del padre al hijo
  lado:number = 0;

  cambiaLado(valor:number) {
    this.lado = valor;
  }

  

  @Output()//del hijo al padre
  propagar = new EventEmitter<number>();

  onPropagar() {
    this.propagar.emit(this.lado);
  }

  

  constructor() { }

  ngOnInit(): void {
  }

}
