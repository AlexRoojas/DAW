import { Component, OnInit } from '@angular/core';
import { ProvinciasService } from '../provincias.service';


@Component({
  selector: 'app-lista-provincias',
  templateUrl: './lista-provincias.component.html',
  styleUrls: ['./lista-provincias.component.css']
})
export class ListaProvinciasComponent implements OnInit {

  listaProvincias:any;
  


  constructor(private provs: ProvinciasService) { }

  ngOnInit(){
    this.provs.getProvincias$().subscribe({
      next:(listaProv:any)=>{
        this.listaProvincias=listaProv;
      },
      error:(fallo:any[]) => console.log(fallo)

      
    })

    window.localStorage.setItem("listProv",JSON.stringify(this.listaProvincias))
  }

 

}
