import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { Cliente, Grupo } from '../clientes.module';


@Component({
  selector: 'app-alta-cliente',
  templateUrl: './alta-cliente.component.html',
  styleUrls: ['./alta-cliente.component.css']
})

export class AltaClienteComponent implements OnInit {

  cliente: Cliente = { id:1 ,nombre:"a", cif:"b", direccion:"c", grupo:2}; //objeto
  
  grupos: Grupo[] = [];//array

  constructor(private clientesService : ClientesService) { }//Conseguimos una instancia del servicio de clientes


  ngOnInit(): void { //ya se ha recibido el servicio de clientes
    this.cliente = this.clientesService.nuevoCliente();
    this.grupos = this.clientesService.getGrupos();
    console.log(this.cliente)
  }

  creaNuevoCliente ():void { //se ejecuta cuando se produzca el envio de datos del formulario (alta)
    this.clientesService.agregarCliente(this.cliente);//lo añadimos
    this.cliente = this.clientesService.nuevoCliente();//creamos el nuevo cliente para que no se machaque
  }

}
