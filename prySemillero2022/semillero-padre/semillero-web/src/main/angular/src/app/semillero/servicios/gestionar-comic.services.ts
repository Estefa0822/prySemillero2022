import {HttpClient, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { ComicDTO } from '../dtos/comic.dto';
import { ResultadoDTO } from '../dtos/resultado-dto';


@Injectable({
    providedIn: 'root'
})

export class GestionarComicService{
    constructor(private httpCliente: HttpClient){}


    public obtenerComics(): Observable<any>{
        return this.httpCliente.get('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/obtenerComics');
    }

    //Crear un comic, con el comicdto que tengo en patalla
    public crearComic(comicDTO: ComicDTO): Observable<ResultadoDTO>{
        return this.httpCliente.post<ResultadoDTO>('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/crearComic', comicDTO);
    }


    public consultarComicTamanioNombre(longitudNombre: string): Observable<any>{
        let parametros = new HttpParams();
        parametros.set("lenghtComic", longitudNombre); //Solo recibe numeros... de forma automática se hará el casteo en el servicio
        //parametros.set("comicDTO", JSON.stringify(ComicDTO)); //Si necesito enviar un comic dto por ejemplo para editar varios campos al tiempo
        
        return this.httpCliente.get('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/consultarComicTamanioNombre', {params: parametros});
    }

    
    

}