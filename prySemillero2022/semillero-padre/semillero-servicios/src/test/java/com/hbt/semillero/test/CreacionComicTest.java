package com.hbt.semillero.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoComicEnum;
import com.hbt.semillero.enums.TematicaEnum;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CreacionComicTest {
	private final static Logger LOGGER = Logger.getLogger(CreacionVehiculoTest.class);
	List<Comic> listaComics;
	
	@Before
	public void inicializar() {
		//Se realiza la configuración básica inicial al logger que estoy creando
		BasicConfigurator.configure();
		LOGGER.info("Se inicia configuración de log4j antes de ejecutar "); 
		
		//Creación de objetos de tipo Comic
		Comic comicAventura = new Comic("Hora de aventura vol 5", 
										"norma editorial", 
										TematicaEnum.AVENTURAS, 
										"Hora de aventura", 
										12, new BigDecimal(19800), 
										"Ryan North,Pendleton Ward,Jim Rugg", 
										true, EstadoComicEnum.ACTIVO, 
										(short)10);
		Comic comicAventura2 = new Comic("¡Precaución: Aprendiz de conductor!", 
										"S.A. EDICIONES B", 
										TematicaEnum.AVENTURAS, 
										"Bob Esponja", 
										8, new BigDecimal(41900), 
										"Stephen Hillenburg", 
										true, EstadoComicEnum.ACTIVO, 
										(short)2);
		Comic comicHumor = new Comic("El caso del velo", 
										"Norma editorial", 
										TematicaEnum.HUMORISTICO, 
										"Jack Palmer", 
										48, new BigDecimal(124000), 
										"Rene Petillon", 
										true, EstadoComicEnum.INACTIVO, 
										(short)0);
		Comic comicFantastico = new Comic("Robin Hood vol 1", 
										"Santillana ediciones generales SL", 
										TematicaEnum.FANTASTICO, 
										"Robin Hood", 
										24, new BigDecimal(76000), 
										"Victor Hugo Tequendama", 
										true, EstadoComicEnum.INACTIVO, 
										(short)0);
		Comic comicDeporte = new Comic("El boxeador", 
										"Panamericana librerias", 
										TematicaEnum.DEPORTIVO, 
										"", 
										15, new BigDecimal(13000), 
										"Robert Fitzooth", 
										false, EstadoComicEnum.ACTIVO, 
										(short)3);
		Comic comicFiccion = new Comic("Cuantix", 
										"Alinza editorial", 
										TematicaEnum.CIENCIA_FICCION, 
										"Libros singulares", 
										176, new BigDecimal(345000), 
										"Laurent Schafer", 
										true, EstadoComicEnum.ACTIVO, 
										(short)1);
		Comic comicHistoria = new Comic("Tanta Sangre vista parte I", 
										"editorial SA", 
										TematicaEnum.HISTORICO, 
										"Tanta sangre vista", 
										120, new BigDecimal(31000), 
										"Camilo Marquez", 
										false, EstadoComicEnum.ACTIVO, 
										(short)12);
		Comic comicHorror = new Comic("Locke & Key", 
										"IDW Publishing", 
										TematicaEnum.HORROR, 
										"Locke & Key", 
										36, new BigDecimal(98200), 
										"Gabriel Rodríguez", 
										false, EstadoComicEnum.ACTIVO, 
										(short)3);
		Comic comicFantastico2 = new Comic("Cuentos ilustrados de Rafael Pombo edicion actualizada 2021", 
										"Intermedio", 
										TematicaEnum.FANTASTICO, 
										"", 
										160, new BigDecimal(48000), 
										"Rafael Pombo", 
										true, EstadoComicEnum.ACTIVO, 
										(short)18);
		Comic comicBelico = new Comic("The Walking Dead vol. 11", 
								"Editorial Vuk", 
								TematicaEnum.BELICO, 
								"The Walking Dead", 
								66, new BigDecimal(52000), 
								"Robert Kirkman", 
								true, EstadoComicEnum.ACTIVO, 
								(short)6);
		
				
		//Se adicionan a la lista de comics, los comics creados previamente
		listaComics= new ArrayList<>();
		listaComics.add(comicAventura);
		listaComics.add(comicAventura2);
		listaComics.add(comicHumor);
		listaComics.add(comicFantastico);
		listaComics.add(comicDeporte);
		listaComics.add(comicFiccion);
		listaComics.add(comicHistoria);
		listaComics.add(comicHorror);
		listaComics.add(comicFantastico2);
		listaComics.add(comicBelico);
		
				
	}
	/**
	 * 
	 * Metodo encargado de retornar la lista con los comics que se encuentran activos
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania Gomez Cardenas	 * 
	 * @return List retorna la lista de comics que se encuentran activos
	 */
	private List<Comic> obtenerComicsActivos(){
		List<Comic> listaComicsActivos =new ArrayList<>();
		System.out.println("Listado los comics activos:");
		for (Comic comic : listaComics) {
			//Si el comic tiene estado activo, entonces lo adiciona a la lista de comic activos
			if (comic.getEstado().equals(EstadoComicEnum.ACTIVO)) {
				listaComicsActivos.add(comic);				
				System.out.println(comic.toString());
			}			
		}
		return listaComicsActivos;		
	}
	/**
	 * 
	 * Metodo encargado de retornar la lista de los comic que se encuentran inactivos
	 * <b>Caso de Uso</b> Semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 * @return List Retorna una lista con los comics inactivos
	 */
	private List<Comic> obtenerComicsInactivos(){
		List<Comic> listaComicsInactivos =new ArrayList<>();
		System.out.println("Listando los comics inactivos:");
		for (Comic comic : listaComics) {
			//Si el comic tiene estado inactivo, entonces lo adiciona a la lista de comic inactivos
			if (comic.getEstado().equals(EstadoComicEnum.INACTIVO)) {
				listaComicsInactivos.add(comic);				
				System.out.println(comic.toString());
			}			
		}				
		return listaComicsInactivos;		
	}
		
	/**
	 * 
	 * Metodo encargado de verificar que todos los comics se encuentren activos
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania Gomez Cardenas	 * 
	 * @return boolean Todos los comics se encuentran activos
	 * @throws Exception Se lanza en caso de encontrar un comic inactivo en la lista de comics
	 */
	private boolean verificarEstado() throws Exception {	
		System.out.println("Verificando estado...");
		List<Comic> listaComicsActivos = obtenerComicsActivos();
		List<Comic> listaComicsInactivos = obtenerComicsInactivos();
		
		//En caso de que se encuentre un comic inactivo o más, se lanza una excepción indicándolo
		if (listaComicsInactivos !=null &&  listaComicsInactivos.size() > 0) {
			throw new Exception("Se ha detectado que de " + listaComics.size() + 
								" se encuentran activos " + (listaComicsActivos != null? listaComicsActivos.size():0) + " y " +
								listaComicsInactivos.size() + " se encuentran inactivos");	
		}
		return true;		
	}
			
	
	/**
	 * 
	 * Metodo encargado de probar que el método obtenerComicsActivos esté retornando únicamente comics activos
	 * <b>Caso de Uso</b> Semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 *
	 */
	@Test
	public void probarObtenercomicsActivos() {
		LOGGER.info("Se inicia la prueba del método obtenerComicsActivos");
		System.out.println("Prueba: obtenerComicsActivos, cuando todos los comics son activos");
		assertNotNull(listaComics); //Se espera que la lista de comics NO sea nula
		List <Comic> listaComicsActivos = obtenerComicsActivos();
		assertNotNull(listaComicsActivos); //Se espera que no sea nula, puesto que en inicializar se configuraron algunas activas
		for (Comic comic : listaComicsActivos) {
			assertEquals(comic.getEstado(),EstadoComicEnum.ACTIVO);
		}
		LOGGER.info("Finaliza la prueba del método obtenerComicsActivos");
	}
	
	/**
	 * 
	 * Metodo encargado de probar que el método verificarEstado ejecute sin error cuando todos los comics sean activos 
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 * @throws Exception Replica el error generado cuando se detecte un comic inactivo
	 */
	
	@Ignore
	public void probarVerificarEstado() throws Exception {
		LOGGER.info("Inicia la prueba del método verificarEstado cuando los comics son activos");
		System.out.println("Prueba: verificarEstado cuando los comics son activos");
		assertNotNull(listaComics); //Se espera que la lista de comics NO sea nula
		//cuando se verifique el estado de cualquier comic, se va a indicar que es Activo
		Comic comic = new Comic();
		comic = mock(Comic.class);
		when(comic.getEstado()).thenReturn(EstadoComicEnum.ACTIVO);
		
		assertTrue(verificarEstado()); //se espera que todos los comics estén activos
		LOGGER.info("Finaliza la prueba del método verificarEstado");
	}
	/**
	 * Metodo encargado de probar que el método verificarEstado capture el error cuando detecte un comic inactivo 
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefanía Gómez Cardenas
	 *
	 */
	
	@Ignore
	public void probarVerificarEstadoRetorneError() {
		LOGGER.info("Inicia la prueba del método verificarEstado");
		System.out.println("Prueba: verificarEstado cuando todos son inactivos");
		boolean resultado = false;
		assertNotNull(listaComics); //Se espera que la lista de comics NO sea nula
		//cuando se verifique el estado de cualquier comic, se va a indicar que es inactivo
		Comic comic = new Comic();
		comic = mock(Comic.class);
		when(comic.getEstado()).thenReturn(EstadoComicEnum.INACTIVO);
		
		try {
			resultado = verificarEstado();
		} catch (Exception e) {
			//log
			System.out.println("Se generó error al ejecutar el método de verificar estado");
		}
		assertFalse(resultado); //se espera un error
	}
	
	/**
	 * Test encargado de probar que se genere un error cuando se encuentre en la lista una comic inactivo
	 * <b>Caso de Uso</b>Semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 *
	 */
	@Test
	public void probarVerificarEstadoFalla() {
		LOGGER.info("Inicia la prueba del método verificarEstado cuando tiene un comic inactivo");
		System.out.println("Prueba: Verificar estado falla");
		boolean resultado = false;
		assertNotNull(listaComics); //Se espera que la lista de comics NO sea nula
		listaComics.get(0).setEstado(EstadoComicEnum.INACTIVO); //pone un item inactivo		
		try {
			resultado = verificarEstado();
		} catch (Exception e) {
			//log
			System.out.println("Se generó error al ejecutar el método de verificar estado");
		}
		assertFalse(resultado); //se espera un error
		LOGGER.info("Finaliza la prueba del método verificarEstado cuando tiene un comic inactivo");
	}
	
	@Test
	public void probarVerificarEstadoOK() {
		LOGGER.info("Inicia la prueba del método verificarEstado cuando todos los comics son activos");
		System.out.println("Prueba: VerificarEstado resultado Ok");
		boolean resultado = false;
		assertNotNull(listaComics); //Se espera que la lista de comics NO sea nula
		//Activa todos los comics que estén en la lista
		for (Comic comic : listaComics) {
			comic.setEstado(EstadoComicEnum.ACTIVO);			
		}
		
		try {
			resultado = verificarEstado();
		} catch (Exception e) {
			LOGGER.info("se genera error en la prueba");
		}
		assertTrue(resultado);
		LOGGER.info("Finaliza la prueba del método verificarEstado cuando tiene un comic activo");
	}
	
	

}
