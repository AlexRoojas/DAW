import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'primer-proyecto-angulaARAR';
  visible:boolean = false;
  etiqueta:String="Decir Adiós";

  decirAdios(){
    if(this.visible==true){
      this.visible = false;
      this.etiqueta="Decir Adiós";
    }else{
      this.visible=true;
      this.etiqueta="Ocultar Adios";
    }
    
    
  }
}
