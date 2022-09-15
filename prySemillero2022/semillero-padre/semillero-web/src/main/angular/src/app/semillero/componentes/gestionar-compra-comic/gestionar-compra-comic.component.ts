import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ComicDTO } from "../../dtos/comic.dto";
import { GestionarCompraComicService } from "../../servicios/gestionar-compra-comic.services";

@Component({
    selector:'app-gestionar-compra-comic',
    templateUrl:'./gestionar-compra-comic.component.html'    
})

export class GestionarCompraComic implements OnInit{
    public comicDTO : ComicDTO;
    public exitoso : boolean;
    public mensajeEjecucion: string;
    public mostrarItem: boolean;

      constructor(private activateRoute: ActivatedRoute, private gestionarCompraComicService : GestionarCompraComicService, private router : Router){

      }


     ngOnInit(): void {
        this.comicDTO = new ComicDTO();
        this.comicDTO = <ComicDTO> this.activateRoute.snapshot.params; //Recibe el comic de un parámetro
        console.log(this.comicDTO.nombre);
    }


    public comprarComic(): void{
        
        //this.comicDTO.fechaVenta = new Date();
        this.gestionarCompraComicService.comprarComic(this.comicDTO).subscribe((resultado : any)=>{
            this.mostrarItem = true;
            this.exitoso = resultado.exitoso;
            this.mensajeEjecucion = resultado.mensaje;            
        });
    }

    public cerrar():void{
        this.mostrarItem = false;        
    }

    public retornar():void{
        this.router.navigate(['gestionar-comic']);
    }
    

    

    

}