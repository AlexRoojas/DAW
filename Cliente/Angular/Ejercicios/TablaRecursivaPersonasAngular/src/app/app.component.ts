import { Component, OnInit,Output } from '@angular/core';
import { UsersService } from './users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  listaUsuarios:any=[];

  valores:any=[];

  ngOnInit(): void {
    this.userservice.getUsers().subscribe((response: any) => this.listaUsuarios=response);
  }

  title = 'listarPersonas';

  constructor(private userservice: UsersService){
    console.log("El componente se ha creado");
  }

  esUnObjeto(objetoComprobar:any):boolean{
    if(typeof objetoComprobar == 'object'){
        return false;
    }

    return true;
  }

  
}
