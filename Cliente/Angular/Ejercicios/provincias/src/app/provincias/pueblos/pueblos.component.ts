import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ProvinciasService } from '../provincias.service';

@Component({
  selector: 'app-pueblos',
  templateUrl: './pueblos.component.html',
  styleUrls: ['./pueblos.component.css']
})
export class PueblosComponent implements OnInit {

  idProvincia:any;

  misPueblosSelec:any[] =[];

  constructor(private miRuta: ActivatedRoute,private miServicio:ProvinciasService) { }

  ngOnInit(): void {

    this.idProvincia=this.miRuta.snapshot.paramMap.get("codigo"); 
    if(this.idProvincia!=null)
      this.miServicio.getPueblos$(this.idProvincia).subscribe((response: any) =>this.misPueblosSelec=response);
    else{
      this.miServicio.getTodosPueblos$().subscribe({
        next:(listaPue:any)=>{
          this.misPueblosSelec=listaPue;
        },
        error:(fallo:any[]) => console.log(fallo)
  
        
      })
    }
    //Actualizamos la peticion del parámetro  
    this.miRuta.params.subscribe(params => {
      
        this.idProvincia=params["codigo"];

        this.miServicio.getPueblos$(this.idProvincia).subscribe((response: any) =>this.misPueblosSelec=response);
      }
    );
  }

}
