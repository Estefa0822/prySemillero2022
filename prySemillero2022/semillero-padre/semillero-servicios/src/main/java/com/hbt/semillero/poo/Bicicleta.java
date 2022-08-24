package com.hbt.semillero.poo;

import com.hbt.semillero.poo.abstracts.AccionesVehiculoAbstract;

public class Bicicleta extends AccionesVehiculoAbstract{

	public Bicicleta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int obtenerVelocidadMaxima() {
		return 10;
	}

	@Override
	public Long obtenerPesoMaximoCarga() {
		return 90L;
	}
	
	

}
