import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primer-componente',
  templateUrl: './primer-componente.component.html',
  styleUrls: ['./primer-componente.component.css']
})
export class PrimerComponenteComponent implements OnInit {

  dato = "Creando componentes para DesarrolloWeb.com";
  
  constructor() {
    console.log('componente construido...');
  }

  ngOnInit() {
    console.log('componente inicializado...');
  }

}
