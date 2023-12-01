import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { Cliente, Grupo } from '../clientes.module';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-listado-clientes',
  templateUrl: './listado-clientes.component.html',
  styleUrls: ['./listado-clientes.component.css']
})
export class ListadoClientesComponent implements OnInit {

  constructor(private clientesService: ClientesService) { }//instanciamos

  clientes: Cliente[]=[];

  obsClientes$: Observable<Cliente[]> | undefined;

  ngOnInit(): void {
    
    this.obsClientes$ = this.clientesService.getClientes$();//accedemos al observable, que escucha los eventos que necesitamos consumir
    this.obsClientes$.subscribe(misclientes => this.clientes=misclientes)//
  }

}
