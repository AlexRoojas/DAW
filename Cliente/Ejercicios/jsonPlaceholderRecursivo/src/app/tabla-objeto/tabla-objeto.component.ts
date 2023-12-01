import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabla-objeto',
  templateUrl: './tabla-objeto.component.html',
  styleUrls: ['./tabla-objeto.component.css']
})
export class TablaObjetoComponent implements OnInit {

  @Input()
  objeto:any={};
  constructor() { }

  ngOnInit(): void {
  }

  esObjeto(dato:any):boolean{
    if(typeof dato == "object")
      return true;
    else return false;
  }

}
