package com.hbt.semillero.enums;

public enum TipoVehiculoEnum {

	TERRESTRE("Terrestre",1),
	ACUATICO("Acuatico",2),
	AEREO("Aereo",3),
	ESPACIAL("Espacial",4)
	
	
	;
	
	private String tipo;
	private int identificador;
	
	TipoVehiculoEnum(String tipo, int identificador){
		this.identificador=identificador;
		this.tipo=tipo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	
	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	
	
	
}
