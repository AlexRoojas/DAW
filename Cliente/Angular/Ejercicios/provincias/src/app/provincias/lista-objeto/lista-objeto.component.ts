import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-objeto',
  templateUrl: './lista-objeto.component.html',
  styleUrls: ['./lista-objeto.component.css']
})
export class ListaObjetoComponent implements OnInit {
  @Input()
  objeto:any={};

  constructor() { }

  ngOnInit(): void {
  }

}
