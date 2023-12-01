import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaProvinciasComponent } from './lista-provincias/lista-provincias.component';
import { ProvinciasService } from './provincias.service';
import { HttpClientModule } from '@angular/common/http';
import { ListaObjetoComponent } from './lista-objeto/lista-objeto.component';
import { PueblosComponent } from './pueblos/pueblos.component';
import { RouterModule,Routes } from '@angular/router';
import { ModificaProvComponent } from './modifica-prov/modifica-prov.component';

import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import { ErrorStateMatcher, ShowOnDirtyErrorStateMatcher } from '@angular/material/core';

export const rutas: Routes =[
  {path:"Pueblos/:codigo",component: PueblosComponent},
  {path:"Provincia",component: ListaProvinciasComponent},
  {path:"TodosPueblos",component: PueblosComponent},
  {path:"modProv/:miCod",component: ModificaProvComponent}
]

@NgModule({
  declarations: [
    ListaProvinciasComponent,
    ListaObjetoComponent,
    PueblosComponent,
    ModificaProvComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule.forRoot(rutas),
    MatButtonModule,
    MatIconModule,
    MatMenuModule
  ],
  providers:[ProvinciasService
  ],
  exports:[
    ListaProvinciasComponent,
    RouterModule
  ]
})
export class ProvinciasModule { }
