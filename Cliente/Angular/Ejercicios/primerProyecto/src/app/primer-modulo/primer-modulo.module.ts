import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SegundoComponenteComponent } from './segundo-componente/segundo-componente.component';
import { FormsModule } from '@angular/forms';
import { PruebaNgModelComponent } from './prueba-ng-model/prueba-ng-model.component';


@NgModule({
  declarations: [
    SegundoComponenteComponent,
    PruebaNgModelComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
    SegundoComponenteComponent,
    PruebaNgModelComponent
  ]
})
export class PrimerModuloModule { }
