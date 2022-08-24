package com.hbt.semillero.poo.abstracts;

public abstract class AccionesVehiculoAbstract {

	//Tenemos el qué, pero no tenemos el cómo
	//Los cuales deben ser implementados en los hijos
	public abstract int obtenerVelocidadMaxima();
	public abstract Long obtenerPesoMaximoCarga();
	
	//Todos van a tener este comportamiento, a no ser de que se sobreescriba en los hijos. 
	public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}

}
