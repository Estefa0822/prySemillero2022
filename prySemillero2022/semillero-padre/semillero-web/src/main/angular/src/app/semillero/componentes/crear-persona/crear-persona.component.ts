import { Component, OnInit } from "@angular/core";

@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona.component.html'
})

export class CrearPersonaComponent implements OnInit{

    public saludo: string;


    ngOnInit(): void {
        this.saludo = "Hola semillero 2022"
    }

}