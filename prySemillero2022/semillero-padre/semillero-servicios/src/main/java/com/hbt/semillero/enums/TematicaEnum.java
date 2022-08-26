package com.hbt.semillero.enums;
/**
 * 
 * <b>Descripción:<b> Clase que determina los enumeradores del atributo tematica para el comic
 * <b>Caso de Uso:<b> 
 * @author Familia
 * @version
 */
public enum TematicaEnum {

	/*
	 * En archivo de propiedades, se realizará las traducciones 
	 */
	
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematicas.belico"),
	HUMORISTICO("enum.tematicas.humoristico"),
	DEPORTIVO("enum.tematicas.deportivo"),
	FANTASTICO("enum.tematicas.fantastico"),
	CIENCIA_FICCION("enum.tematicas.cienciaFiccion"),
	HISTORICO("enum.tematicas.historico"),
	HORROR("enum.tematicas.horror"),
	
	
	
	
	;
	
	private String etiqueta;
	TematicaEnum(String descripcion) {
		this.etiqueta = descripcion;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
		
	
	
	
}
