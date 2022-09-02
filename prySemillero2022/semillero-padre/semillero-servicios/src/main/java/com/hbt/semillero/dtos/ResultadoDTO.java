package com.hbt.semillero.dtos;

import java.io.Serializable;

public class ResultadoDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private boolean exitoso;
	private String mensaje;
	
	
	public ResultadoDTO() {
		//Constructor vacio
	}
	
	public ResultadoDTO(boolean exitoso, String mensaje) {
		super();
		this.exitoso = exitoso;
		this.mensaje = mensaje;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo exitoso
	 * @return El exitoso asociado a la clase
	 */
	public boolean isExitoso() {
		return exitoso;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo exitoso
	 * @param exitoso El nuevo exitoso a modificar.
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo mensaje
	 * @return El mensaje asociado a la clase
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo mensaje
	 * @param mensaje El nuevo mensaje a modificar.
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
