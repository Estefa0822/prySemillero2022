package com.hbt.semillero.dtos;

import java.io.Serializable;
/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Estefania Gomez Cardenas
 * @version
 */

import java.math.BigDecimal;

import com.hbt.semillero.util.JsonUtils;


public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	/**
	 * Atributo que permite la serializacion  
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private BigDecimal precio;
	
	
	
	
	public ConsultaNombrePrecioComicDTO() {
		//Constructor vacío
	}
	
	
	
	public ConsultaNombrePrecioComicDTO(String nombre, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	/**
	 * 
	 * Metodo encargado de convertir los datos recibidos en JSON al tipo comicDTO 
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Estefanía Gomez Cardenas	 * 
	 * @param arg Cadena que representa el objeto complejo JSON
	 * @return Instancia con los datos recibidos
	 */
	public static ComicDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, ComicDTO.class);
	}
	

	/** 
	 * Metodo encargado de convertir los datos recibidos en ComicDTO al JSON esperado
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
	
	
	
	



	
	
	
	
	

}
