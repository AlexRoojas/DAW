import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { Cliente, Grupo } from '../clientes.module';

@Component({
  selector: 'app-listado-clientes',
  templateUrl: './listado-clientes.component.html',
  styleUrls: ['./listado-clientes.component.css']
})
export class ListadoClientesComponent implements OnInit {

  constructor(private clientesService: ClientesService) { }//instanciamos

  clientes: Cliente[]=[];

  ngOnInit(): void {
    this.clientes = this.clientesService.getClientes();
  }

}
