package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public interface IAccionesVehiculo {
	public abstract int obtenerVelocidadMaxima();
	public abstract Long obtenerPesoMaximoCarga();
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception;
	
	//Se usa la palabra default para implementar un método.  
	default public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}
	
	
	
}
