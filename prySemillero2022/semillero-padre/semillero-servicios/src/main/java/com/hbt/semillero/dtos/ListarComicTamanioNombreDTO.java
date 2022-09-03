package com.hbt.semillero.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListarComicTamanioNombreDTO extends ResultadoDTO implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * Constructor de la clase, que inicializa las listas. 
	 */
	public ListarComicTamanioNombreDTO() {		
		this.listaComicSuperanTamanio = new ArrayList<>();
		this.listaComicNoSuperanTamanio = new ArrayList<>();
	}

	/*
	 * Atributo que contiene la lista de los nombres de los comics que  superan el tamaño ingresado en el servicio
	 */
	private List<String> listaComicSuperanTamanio;
	
	/*
	 * Atributo que contiene la lista de los nombres de comics que no superan el tamaño ingresado en el servicio
	 */
	private List<String> listaComicNoSuperanTamanio;

	/**
	 * Metodo encargado de retornar el valor del atributo listaComicSuperanTamanio
	 * @return El listaComicSuperanTamanio asociado a la clase
	 */
	public List<String> getListaComicSuperanTamanio() {
		return listaComicSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComicSuperanTamanio
	 * @param listaComicSuperanTamanio El nuevo listaComicSuperanTamanio a modificar.
	 */
	public void setListaComicSuperanTamanio(List<String> listaComicSuperanTamanio) {
		this.listaComicSuperanTamanio = listaComicSuperanTamanio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComicNoSuperanTamanio
	 * @return El listaComicNoSuperanTamanio asociado a la clase
	 */
	public List<String> getListaComicNoSuperanTamanio() {
		return listaComicNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComicNoSuperanTamanio
	 * @param listaComicNoSuperanTamanio El nuevo listaComicNoSuperanTamanio a modificar.
	 */
	public void setListaComicNoSuperanTamanio(List<String> listaComicNoSuperanTamanio) {
		this.listaComicNoSuperanTamanio = listaComicNoSuperanTamanio;
	}
	
	/**
	 * 
	 * Metodo encargado de insertar un nombre en la lista de DTO 
	 * <b>Caso de Uso</b> Semillero2022TallerRest
	 * @author Estefanía Gómez Cardenas
	 * 
	 * @param nombreComic String 
	 */
	public void addComicNoSuperaTamanio(String nombreComic) {
		this.listaComicNoSuperanTamanio.add(nombreComic);
	}
	
	/**
	 * 
	 * Metodo encargado de insertar un nombre de comic que superta un determinado tamaño  
	 * <b>Caso de Uso</b> Semillero2022TallerRest
	 * @author Estefania Gomez Cardenas
	 * 
	 * @param nombreComic
	 */
	public void addComicSuperaTamanio(String nombreComic) {
		this.listaComicSuperanTamanio.add(nombreComic);
	}
	
	
	
	
}
