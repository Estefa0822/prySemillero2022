package com.hbt.semillero.dtos;

import java.time.LocalDate;

import com.hbt.semillero.enums.EstadoComicEnum;
/*
 * Clase que permite la persistencia para la compra de un comic
 */
public class CompraComicDTO extends ResultadoDTO {
	
	private Long id;
	private LocalDate fechaVenta;
	private Short cantidad;
	private EstadoComicEnum estadoEnum;
	
	public CompraComicDTO() {
		//constructor vacio
	}
	
	
	public CompraComicDTO(Long id, LocalDate fechaVenta, Short cantidad, EstadoComicEnum estadoEnum) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.estadoEnum = estadoEnum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Short getCantidad() {
		return cantidad;
	}
	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}
	public EstadoComicEnum getEstadoEnum() {
		return estadoEnum;
	}
	public void setEstadoEnum(EstadoComicEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}
	
	

}
