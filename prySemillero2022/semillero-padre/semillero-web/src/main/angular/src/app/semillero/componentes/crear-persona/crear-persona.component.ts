import { Component, OnInit } from "@angular/core";
import { ComicDTO } from "../../dtos/comic.dto";
import { EstadoEnum } from "./enums/estado.enum";
import { TematicaEnum } from "./enums/tematica.enum";

@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona.component.html'
})

export class CrearPersonaComponent implements OnInit{

    public saludo: string;
    public comics : Array<any>;
    public comicsTematicaHorror: Array<ComicDTO>;
    public comicsTematicaHumoristico: Array<ComicDTO>;
    public imagen: any;

    ngOnInit(): void {
        this.saludo = "Hola semillero 2022"
        this.comics = this.crearComic();
        let url = "https://alfabetajuega.com/hero/2022/09/Goku-y-Superman-intercambian-sus-trajes-en-esta-version-alternativa-que-te-encantara.jpg?width=768&aspect_ratio=16:9&format=nowebp";
        let height: number = 500;
        let width: number = 700;

        this.imagen = this.asignarImagen(url, height, width);

        let comics = new Map<string, Array<ComicDTO>>();
        this.comicsTematicaHorror = new Array<ComicDTO>();
        
        let comicBatman = new ComicDTO("batman",TematicaEnum.HORROR, 900);
        let comicDragonBall = new ComicDTO("Dragon Ball", TematicaEnum.HORROR, 800);

        this.comicsTematicaHorror.push(comicBatman);
        this.comicsTematicaHorror.push(comicDragonBall);

        this.comicsTematicaHumoristico = new Array<ComicDTO>();
        let comicChavo = new ComicDTO("Chavo del ocho", TematicaEnum.HUMORISTICO, 765);
        let comicChapulin = new ComicDTO("Chapulin colorado", TematicaEnum.HUMORISTICO,450);

        this.comicsTematicaHumoristico.push(comicChavo);
        this.comicsTematicaHumoristico.push(comicChapulin);

        //Mapa
        //Asigno a horror, la lista de comics de horror
        comics.set(TematicaEnum.HORROR, this.comicsTematicaHorror);
        //Asigno a humoristico, la lista de comics de humor
        comics.set(TematicaEnum.HUMORISTICO, this.comicsTematicaHumoristico);

        let comicHumoristicos = comics.get(TematicaEnum.HUMORISTICO);
        console.log("Comics humoristicos " + JSON.stringify(comicHumoristicos) );
        comics.forEach((value: Array<ComicDTO>, key: string) =>{
            if(TematicaEnum.HORROR == key){
                console.log("Lista comics horror: " + key + " " + JSON.stringify(value));
            }else{
                console.log("Lista de comics humoristico " + key + " " + JSON.stringify(value));
            }
        });






    }


    private crearComic():Array<any>{
        let listacomics: Array<any>;

        let comicSuperman: any = {
            nombre: "superman",
            estado: EstadoEnum.ACTIVO,
            precio: 190000,
            tematica: TematicaEnum.CIENCIA_FICCION,
            fechaVenta: new Date(),
            color: true
        }

        let comicThor: any = {
            nombre: "thor",
            estado: EstadoEnum.ACTIVO,
            precio: 170000,
            tematica: TematicaEnum.CIENCIA_FICCION,
            fechaVenta: null,
            color: true
        }

        let comicSpiderman: any = {
            nombre: "thor",
            estado: EstadoEnum.ACTIVO,
            precio: 1000,
            tematica: TematicaEnum.HUMORISTICO,
            fechaVenta: null,
            color: true
        }

        listacomics = new Array<any>();
        listacomics.push(comicSuperman);
        listacomics.push(comicThor);
        listacomics.push(comicSpiderman);

        return listacomics;

    }

    public asignarImagen(url: string, height: number, width: number): any{
        return{
            url: url,
            height: height,
            width: width
        }
    }

    public mostrarDescripcionImagen(): void{
        console.log(JSON.stringify(this.imagen));
        alert("Info imagen " + JSON.stringify(this.imagen));
    }


}