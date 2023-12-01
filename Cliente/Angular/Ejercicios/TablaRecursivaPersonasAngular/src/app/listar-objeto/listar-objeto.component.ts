import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-listar-objeto',
  templateUrl: './listar-objeto.component.html',
  styleUrls: ['./listar-objeto.component.css']
})
export class ListarObjetoComponent implements OnInit {
  
  @Input()
  objeto:any;


  constructor() { }

  ngOnInit(): void {
  }

  esUnObjeto(objetoComprobar:any):boolean{
    if(typeof objetoComprobar == 'object'){
        return false;
    }
    return true;
  }

}
