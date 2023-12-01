import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PrimerComponenteComponent } from './primer-componente/primer-componente.component';

import { PrimerModuloModule } from './primer-modulo/primer-modulo.module';
import { PruebaNgModelComponent } from './primer-modulo/prueba-ng-model/prueba-ng-model.component';

@NgModule({
  declarations: [
    AppComponent,
    PrimerComponenteComponent
  ],
  imports: [
    BrowserModule,
    PrimerModuloModule
  ],
  providers: [],
  bootstrap: [AppComponent,PruebaNgModelComponent]
})
export class AppModule { }
