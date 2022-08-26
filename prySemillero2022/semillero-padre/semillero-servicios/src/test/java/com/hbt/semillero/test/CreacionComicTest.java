package com.hbt.semillero.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoComicEnum;
import com.hbt.semillero.enums.TematicaEnum;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreacionComicTest {
	List<Comic> listaComics;
	@Before
	public void inicializar() {
		//Se crea comic de aventura
		/*String autores[] = new String[2];
		autores[0] = "Ryan North";
		autores[1] = "Pendleton Ward";
		autores[2] = "Jim Rugg";*/
	
		Comic comicAventura = new Comic("Hora de aventura vol 5", 
										"norma editorial", 
										TematicaEnum.AVENTURAS, 
										"Hora de aventura", 
										12, new BigDecimal(19800), 
										"Ryan North,Pendleton Ward,Jim Rugg", 
										true, EstadoComicEnum.ACTIVO, 
										(short)0);
		Comic comicAventura2 = new Comic("¡Precaución: Aprendiz de conductor!", 
										"S.A. EDICIONES B", 
										TematicaEnum.AVENTURAS, 
										"Bob Esponja", 
										8, new BigDecimal(41900), 
										"Stephen Hillenburg", 
										true, EstadoComicEnum.ACTIVO, 
										(short)2);
		Comic comicDeportivo = new Comic("¡Precaución: Aprendiz de conductor!", 
				"S.A. EDICIONES B", 
				TematicaEnum.AVENTURAS, 
				"Bob Esponja", 
				8, new BigDecimal(41900), 
				"Stephen Hillenburg", 
				true, EstadoComicEnum.ACTIVO, 
				(short)0);
				
		//Se adicionan a la lista de comics, los comics creados previamente
		listaComics= new ArrayList<>();
		listaComics.add(comicAventura);
		listaComics.add(comicAventura2);
				
	}
	/**
	 * 
	 * Metodo encargado de retornar la lista con los comics que se encuentran activos
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 * 
	 * @return
	 */
	private List<Comic> obtenerComicsActivos(){
		List<Comic> listaComicsActivos =new ArrayList<>();
		
		for (Comic comic : listaComics) {
			//Si el comic tiene estado activo, entonces lo adiciona a la lista de comic activos
			if (comic.getEstado().equals(EstadoComicEnum.ACTIVO)) {
				listaComicsActivos.add(comic);				
			}
		}		
		
		return listaComicsActivos;
		
	}
	/**
	 * 
	 * Metodo encargado de retornar la lista de los comic que se encuentran inactivos
	 * <b>Caso de Uso</b>
	 * @author Familia
	 * 
	 * @return
	 */
	private List<Comic> obtenerComicsInactivos(){
		List<Comic> listaComicsInactivos =new ArrayList<>();
		
		for (Comic comic : listaComics) {
			//Si el comic tiene estado inactivo, entonces lo adiciona a la lista de comic inactivos
			if (comic.getEstado().equals(EstadoComicEnum.INACTIVO)) {
				listaComicsInactivos.add(comic);				
			}
		}		
		
		return listaComicsInactivos;
		
	}
	
	/**
	 * 
	 * Metodo encargado de verificar que todos los comics se encuentren activos
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania
	 * @throws Exception 
	 *
	 */
	/*private boolean verificarEstado() throws Exception {
		
		int cantidadActivos=0;
		int cantidadInactivos=0;
		//Realiza recorrido a la lista de comics para obtener la cantidad de comics que se encuentran con estado activo y cuantos con estado inactivo
		for (Comic comic : listaComics) {
			if (comic.getEstado().equals(EstadoComicEnum.INACTIVO)) {
				cantidadInactivos +=1;	
			}else if (comic.getEstado().equals(EstadoComicEnum.ACTIVO)) {
				cantidadActivos +=1;	
			}
		}
		//En caso de que se encuentre un comic inactivo, se lanza una excepción indicándolo
		if (cantidadInactivos > 0) {
			throw new Exception("Se ha detectado que de " + listaComics.size() + 
								" se encuentran activos " + cantidadActivos + " y " +
								cantidadInactivos + " se encuentran inactivos");	
		}
		return true;
		
	}*/
	
	/**
	 * 
	 * Metodo encargado de verificar que todos los comics se encuentren activos
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean verificarEstado() throws Exception {		
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
		assertNotNull(listaComics); //Se espera que la lista de comics NO sea nula
		List <Comic> listaComicsActivos = obtenerComicsActivos();
		assertNotNull(listaComicsActivos); //Se espera que no sea nula, puesto que en inicializar se configuraron algunas activas
		for (Comic comic : listaComicsActivos) {
			assertEquals(comic.getEstado(),EstadoComicEnum.ACTIVO);
		}		
	}
	
	/**
	 * 
	 * Metodo encargado de probar que el método verificarEstado capture el error cuando detecte un comic inactivo 
	 * <b>Caso de Uso</b> semillero2022Taller1
	 * @author Estefania Gomez Cardenas
	 * @throws Exception 
	 *
	 */
	
	@Test
	public void probarVerificarEstado() throws Exception {
		//List<Comic> listaActivos = new ArrayList();
		//Comic comic1  = new Comic();
		//Comic comic2  = new Comic();
		//comic1.setEstado(EstadoComicEnum.ACTIVO);
		//comic2.setEstado(EstadoComicEnum.ACTIVO);
		//listaActivos.add(comic1);
		//listaActivos.add(comic2);
		
		//mock(this.getClass());
		//when(this.obtenerComicsActivos()).thenReturn(listaActivos);
		//when(this.obtenerComicsActivos()).thenReturn(null);
				
		assertTrue(verificarEstado()); //se espera que todos los comics estén activos
	}
	

}
