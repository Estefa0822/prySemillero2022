package com.hbt.semillero.poo;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.interfaces.IAccionesVehiculo;

public class Automovil extends Vehiculo implements IAccionesVehiculo {

	public Automovil() {
		//Constructor vacío
	}
	
	public Automovil(BigDecimal precio) {
		super(precio);
		super.toString();
	}

	@Override
	public int obtenerVelocidadMaxima() {
		
		return 300;
	}

	@Override
	public Long obtenerPesoMaximoCarga() {
		return 1000L;
	}
	
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception{
		if (TipoVehiculoEnum.TERRESTRE.getIdentificador()==(tipoVehiculoEnum.getIdentificador())) {
			System.out.println("El vehiculo si es de tipo asignado (" + tipoVehiculoEnum.getTipo() + ")");
			return true;
		}else {
			throw new Exception("El tipo de vehiculo asignado es erroneo, debe ser " + TipoVehiculoEnum.TERRESTRE.getTipo());
			
		}
	}

}
