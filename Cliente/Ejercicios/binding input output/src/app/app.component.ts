import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'plantilla-angular';
  ladoInicial:number = 0;
  ladoActual:number = 0;

  actLado(lado:number){
    this.ladoActual=lado;
    console.log(lado)
  }
}
