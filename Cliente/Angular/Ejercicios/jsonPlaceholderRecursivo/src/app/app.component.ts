import { Component, OnInit } from '@angular/core';
import { UsuariosService } from './usuarios.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'plantilla-angular';
  listaUsuarios:any[]=[];
  cabeceras:String[]=[];

  constructor(private servicioUsu : UsuariosService){
    console.log('Componente creado');
  }

  ngOnInit(){
    this.servicioUsu.getUsuario$().subscribe({
      next:(personas: any[]) =>{ 
        this.listaUsuarios=personas;
        console.log(this.listaUsuarios)
        this.cabeceras= Object.keys(this.listaUsuarios[0]);
      },
      error: (fallo:any[]) => console.log(fallo)
    })
  }

  esObjeto(dato:any):boolean{
    if(typeof dato == "object")
      return true;
    else return false;
  }

}
