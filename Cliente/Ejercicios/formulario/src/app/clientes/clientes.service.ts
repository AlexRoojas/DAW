import { Injectable } from '@angular/core';
import { Cliente,Grupo } from './clientes.module';

import { Observable } from 'rxjs';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private clientes: Cliente[];//aray
  private grupos: Grupo[];//array

  private clientes$ = new Subject<Cliente[]>();//creamos un subject de tipo array de Cliente[]
  //provova y emite los eventos

  constructor() {
    this.grupos=[
      {id: 0, nombre: 'Sin definir'},

      {id: 1,nombre: 'Activos'},

      {id: 2,nombre: 'Inactivos'},

      {id: 3,nombre: 'Deudores'},

    ]

    this.clientes=[];

  }

  getGrupos() {
    return this.grupos;
  }

  getClientes() {
    return this.clientes;
  }

  getClientes$(): Observable<Cliente[]> {//observable de tipo Cliente[]
    return this.clientes$.asObservable();
  }

  agregarCliente(cliente: Cliente) {
    this.clientes.push(cliente);
    this.clientes$.next(this.clientes);//emitimos el evento usando el subject
  }

  nuevoCliente(): Cliente { //creamos un nuevo cliente para evitar que se machaque
    return {
      id: this.clientes.length,
      nombre: '',
      cif: '',
      direccion: '',
      grupo: 0
    };
  }

}
