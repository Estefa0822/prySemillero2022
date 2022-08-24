package com.hbt.semillero.poo;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public class Vehiculo {
	
	private short modelo;
	private TipoVehiculoEnum tipo; //Terrestre, aereo
	private double peso;
	private String color;
	private int capacidad;
	private BigDecimal precio;
	
	
	public Vehiculo() {}
	
	public Vehiculo(BigDecimal precio) {
		this.precio = precio;
	}
		
	public Vehiculo(short modelo, TipoVehiculoEnum tipo, double peso, String color, int capacidad, BigDecimal precio) {
		this.modelo = modelo;
		this.tipo = tipo;
		this.peso = peso;
		this.color = color;
		this.capacidad = capacidad;
		this.precio = precio;
	}
	/**
	 * @return the modelo
	 */
	public short getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(short modelo) {
		this.modelo = modelo;
	}
	
		
	
	/**
	 * @return the tipo
	 */
	public TipoVehiculoEnum getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}
	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	/**
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public void encender() {}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", tipo=" + tipo + ", peso=" + peso + ", color=" + color + ", capacidad="
				+ capacidad + ", precio=" + precio + "]";
	}
	
	public void arrancarEnMedio() {
		System.out.println("El vehiculo va avanzando");
	}
	
	
	
	
	

}
