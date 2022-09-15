import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ComicDTO } from "../dtos/comic.dto";
import { ResultadoDTO } from "../dtos/resultado-dto";

@Injectable({
    providedIn: 'root'
})

export class GestionarCompraComicService{
    
    constructor(private httpClient : HttpClient){

    }
    //Consume el servicio de comprar un comic
    public comprarComic(comicDTO : ComicDTO): Observable<ResultadoDTO>{
        return this.httpClient.post<ResultadoDTO>('http://localhost:8085/semillero-servicios/rest/GestionarCompraComicRest/comprarComic', comicDTO);
    }

    

}