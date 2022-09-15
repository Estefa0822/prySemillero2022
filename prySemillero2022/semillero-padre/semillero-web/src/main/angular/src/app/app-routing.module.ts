import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionarComicComponent } from './semillero/componentes/gestionar-comic/gestionar-comic.component';
import { GestionarCompraComic } from './semillero/componentes/gestionar-compra-comic/gestionar-compra-comic.component';

const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent},
  {path : 'gestionar-comic', component: GestionarComicComponent},
  {path : 'gestionar-compra-comic', component: GestionarCompraComic}, 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
