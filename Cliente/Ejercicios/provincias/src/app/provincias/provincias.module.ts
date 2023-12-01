import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaProvinciasComponent } from './lista-provincias/lista-provincias.component';
import { ProvinciasService } from './provincias.service';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    ListaProvinciasComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers:[ProvinciasService],
  exports:[
    ListaProvinciasComponent
  ]
})
export class ProvinciasModule { }
