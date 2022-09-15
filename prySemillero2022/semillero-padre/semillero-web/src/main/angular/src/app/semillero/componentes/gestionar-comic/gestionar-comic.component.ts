import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ComicDTO } from "../../dtos/comic.dto";
import { GestionarComicService } from "../../servicios/gestionar-comic.services";
import { EstadoEnum } from "../crear-persona/enums/estado.enum";
import { TematicaEnum } from "../crear-persona/enums/tematica.enum";

@Component({
    selector:'gestionar-comic',
    templateUrl:'./gestionar-comic.component.html'
    
})

export class GestionarComicComponent implements OnInit{
      public comicDTO : ComicDTO;
      public comicDTOData: ComicDTO;
      public listaComics: Array<ComicDTO>;
      public mostrarItem : boolean;
      public tituloComplemento: any;
      public mostrarData: boolean;
      public estado: string;
      public indice:number;
      public gestionarComicForm: FormGroup;
      public validoFormulario: boolean;
      public mensajeEjecucion: string;
      //Relaciono con formulario reactivo
      constructor(private formBuilder: FormBuilder, private router:Router, 
        private gestionarComicService : GestionarComicService){
        this.gestionarComicForm = this.formBuilder.group({
            nombre: [null, Validators.required],
            editorial: [null, Validators.required],
            tematicaEnum: [null, Validators.required],
            coleccion: [null],
            numeroPaginas: [null, Validators.required],
            precio: [null, Validators.required],
            autores: [null],
            color: [true],
            cantidad: [null],
        });
      }
    ngOnInit(): void {
       //this.tituloComplemento.push(this.comicDTO) ;
       this.comicDTO = new ComicDTO();
       this.mostrarItem = false;
       this.listaComics = new Array<ComicDTO>();
       this.estado="";
       this.obtenerComics(); //Carga los registros de la base de datos
    }

    private obtenerComics() : void{
        //Se está invocando al servicio que consume el método, el suscribe nos va a retornar la información del método
        //En el parametro del suscribe va la respuesta del 
        this.gestionarComicService.obtenerComics().subscribe(comics => {
            if(comics[0].exitoso){ //Se consulta atributo del dto de java... como el atributo y no con get
                this.listaComics = comics;
            }else{
                this.mensajeEjecucion = comics[0].mensajeEjecucion;
            }
        }); 
    }

    public crearComic(): void{
        console.log(this.comicDTO);
        //Si el formulario reactivo encuentra un error de validacion, entonces no realiza el proceso de almacenar el comic
        if(this.gestionarComicForm.invalid){ 
            this.validoFormulario = true;
            return;
        }
        
            
            if (this.estado=="editar"){
                this.listaComics[this.indice]=this.comicDTO;                
                console.log("Editado exitosamente");
            }else{
                this.comicDTO = this.gestionarComicForm.value;
                this.comicDTO.cantidad=1;
                this.comicDTO.estadoEnum=EstadoEnum.ACTIVO;

                this.gestionarComicService.crearComic(this.comicDTO).subscribe(resultadoDTO =>{
                    if(resultadoDTO.exitoso){
                        this.obtenerComics();
                    }else{
                        this.mensajeEjecucion = resultadoDTO.mensaje;
                    }
                    this.validoFormulario = false;      
                    console.log("Almacenado exitosamente");
                    this.mostrarItem = true;
                    this.estado="";
                    this.limpiarForm(); 
                },error =>{
                    console.log();
                } );
                
            }
            
                       
        
    }

    //Consultar por tamaño
    

    //Regresa el formulario a los parámetros iniciales
    public limpiarForm(): void{
        this.gestionarComicForm.reset();
        this.gestionarComicForm.controls.color.setValue(true);
    }

    public eliminarComic(indice: number): void{
        if (this.listaComics !=null){
            console.log(indice);
            this.listaComics.splice(indice, 1);
        }        
    }
    public cerrar():void{
        this.mostrarItem = false;
        this.mostrarData = false;
    }

    public imprimirDataComic(indice: number): void{
        this.comicDTOData = this.listaComics[indice];
        this.mostrarData = true;
    }

    public editar(indice:number):void{
        
        this.comicDTO = this.listaComics[indice]
        this.estado="editar";
        this.indice = indice;
    }
    //Se cargan los datos en el formulario, apartir del comicDTO
    private cargarDatos(){
        this.gestionarComicForm.controls.nombre.setValue(this.comicDTO.nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.comicDTO.editorial);
        this.gestionarComicForm.controls.tematicaEnum.setValue(this.comicDTO.tematicaEnum);
        this.gestionarComicForm.controls.coleccion.setValue(this.comicDTO.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.comicDTO.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.comicDTO.precio);
        this.gestionarComicForm.controls.autores.setValue(this.comicDTO.autores);
        this.gestionarComicForm.controls.color.setValue(this.comicDTO.color);
        this.gestionarComicForm.controls.fechaVenta.setValue(this.comicDTO.fechaVenta);
        this.gestionarComicForm.controls.fechaVenta.setValue(this.comicDTO.fechaVenta);
        this.gestionarComicForm.controls.fechaVenta.setValue(this.comicDTO.fechaVenta);

    }

    public agregarValidacionColeccion():void{
        //Lista de las temáticas para las cuales la coleccción es obligatoria
        let tematicaEnumRequiereColeccion = [TematicaEnum.AVENTURA.toUpperCase(), TematicaEnum.HORROR.toUpperCase()];
        //Obtiene la temática que se seleccionó en el form
        let tematicaSeleccionada = this.f.tematicaEnum.value;
        this.f.coleccion.enable(); //habilita el control de coleccion

        //Verifica si la tematica se encuentra en la lista
        if(tematicaEnumRequiereColeccion.indexOf(tematicaSeleccionada)>=0){
            this.f.coleccion.disable(); //Deshabilita el control de colección
        }
    }

    public irAConsultarComic(comic: ComicDTO):void{
        //Realiza routing a consultar comic, ocultan información en la barra de direcciones
        this.router.navigate(['consultar-comic', comic], {skipLocationChange:true})
    }

    get f(){
        return this.gestionarComicForm.controls;
    }

    //Se realiza direccionamiento al componente que gestiona la compra de comic
    public comprarComic(indice: number): void{
        this.comicDTO = this.listaComics[indice];
       // this.router.navigate(['gestionar-compra-comic', this.comicDTO], {skipLocationChange:true})
       this.router.navigate(['gestionar-compra-comic', this.comicDTO]);
    }


    

}