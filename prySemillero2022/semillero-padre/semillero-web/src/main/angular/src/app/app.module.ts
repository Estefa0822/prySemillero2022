import { APP_BASE_HREF } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { CrearPersonaComponent } from './semillero/componentes/crear-persona/crear-persona.component';
import { GestionarComicComponent } from './semillero/componentes/gestionar-comic/gestionar-comic.component';
import { ConsultarComicComponent } from './semillero/componentes/gestionar-comic/consultar-comic/consultar-comic.component';
import { GestionarCompraComic } from './semillero/componentes/gestionar-compra-comic/gestionar-compra-comic.component';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BienvenidaComponent,
    CrearPersonaComponent,
    GestionarComicComponent,
    ConsultarComicComponent,
    GestionarCompraComic, 

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
  	{ provide: APP_BASE_HREF, useValue: '/SemilleroHBT' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
