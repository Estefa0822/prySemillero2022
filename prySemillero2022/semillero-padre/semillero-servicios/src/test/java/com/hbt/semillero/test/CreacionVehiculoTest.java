package com.hbt.semillero.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.Automovil;
import com.hbt.semillero.poo.Vehiculo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreacionVehiculoTest {

	private final static Logger LOGGER = Logger.getLogger(CreacionVehiculoTest.class);
	
	@Before
	public void inicializar() {
		//Da configuración básica inicial al logger que estoy creando
		BasicConfigurator.configure();
		LOGGER.info("Se inicia configuración de log4j antes de ejecutar "); //imprime en la consi¿ola, mensajes mpas claros del proceso
	}
	
	
	
	
	@Test
	public void whenDeterminarTipoVehiculoGivenTrueThenExito() throws Exception {
		LOGGER.info("Inicia ejecución del test whenDeterminarTipoVehiculoGivenTrueThenExito");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		boolean respuesta = mazda.determinarTipoVehiculo(mazda.getTipo());
		assertTrue(respuesta);
		LOGGER.info("FINALIZA ejecución del test whenDeterminarTipoVehiculoGivenTrueThenExito");
		
	}
	
	 @Test
	 public void ejemploMock() {
		 Automovil kiaMock = new Automovil();
		 kiaMock = mock(Automovil.class);
		 /*
		  * when(kiaMock.acelerar()).thenReturn("El automovil ha tomado velocidad de 15km/h");
		assertEquals(kiaMock.acelerar(), "El automovil ha tomado velocidad de 15km/h");
		  * */
		 
		 LOGGER.info("Finaliza ejecucion del test ejemploMock()");
		 
	 }
	 
	
	

}
