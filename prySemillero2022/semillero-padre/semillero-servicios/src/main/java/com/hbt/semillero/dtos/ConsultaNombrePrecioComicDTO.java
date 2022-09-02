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
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	/**
	 * Atributo que determina  
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
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	
	
	
	

}
