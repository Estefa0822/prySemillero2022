package com.hbt.semillero.poo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public class CreacionVehiculoApp {

	//private static final BigDecimal SMLV = new BigDecimal(1000000);
	private static final String VELOCIDAD_MAXIMA = "Velocidad maxima";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal precio = new BigDecimal(15000000);
		Vehiculo vehiculoMazda = new Vehiculo((short)2022, TipoVehiculoEnum.TERRESTRE, 1000, "Blanco", 5, precio);
		System.out.println("Mazda: " + vehiculoMazda.toString());
		try {
			if (vehiculoMazda.getTipo().equals(TipoVehiculoEnum.TERRESTRE)) {
				System.out.println("El vehiculo es terrestre");
			}
		} catch (Exception e) {
			System.out.println("Estamos presentando un error tecnico");
		}
		
		
		Barco barco = new Barco("Santiago", "Barranquilla", new BigDecimal(234));
		System.out.println("Barco: " + barco.toString());


		//Polimorfismo
		Vehiculo vehiculo1 = new Vehiculo();
		System.out.println("Vehiculo general: ");
		vehiculo1.arrancarEnMedio();
		
		System.out.println("Vehiculo avión: ");
		Avion avion = new Avion();
		avion.arrancarEnMedio();
		
		Avion avion2 = new Avion();
		avion2.arrancarEnMedio();
		
		//Avion avion3 = new Vehiculo(); // Esto genera error puesto que el hijo es avion, no vehiculo. 
		
		System.out.println("Vehiculo Bicicleta");
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.acelerar();
		System.out.println(VELOCIDAD_MAXIMA + " " + bicicleta.obtenerVelocidadMaxima());
		System.out.println("Peso maximo de carga: " + bicicleta.obtenerPesoMaximoCarga());
		
		System.out.println("Automovil");
		Automovil auto = new Automovil(new BigDecimal(9999999));
		auto.acelerar();
		
		auto.setTipo(TipoVehiculoEnum.ACUATICO);
		try {
			auto.determinarTipoVehiculo(auto.getTipo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(VELOCIDAD_MAXIMA + " " + auto.obtenerVelocidadMaxima());
		System.out.println("Peso maximo de carga: " + auto.obtenerPesoMaximoCarga());

		List<Vehiculo> listaVehiculos = new ArrayList<>();
		listaVehiculos.add(auto);
		listaVehiculos.add(vehiculoMazda);
		listaVehiculos.add(barco);
		System.out.println("Se imprimen los precios de los vehiculos");
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getPrecio());
		}
		listaVehiculos.remove(vehiculoMazda);
		System.out.println("otra vez");
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getPrecio());
		}
		System.out.println("Mapas");
		//No permiten datos repetidos
		Map<String, Vehiculo> mapaVehiculos = new HashMap<>();
		mapaVehiculos.put("China", vehiculoMazda);
		mapaVehiculos.put("Japon", barco);
		mapaVehiculos.put("Japon", auto);
		
		System.out.println(mapaVehiculos.get("Japon"));
		
		
		
		
		
		
		
	}

}
