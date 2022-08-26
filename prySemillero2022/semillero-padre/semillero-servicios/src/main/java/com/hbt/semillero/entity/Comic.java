package com.hbt.semillero.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.EstadoComicEnum;
import com.hbt.semillero.enums.TematicaEnum;


/**
 * 
 * <b>Descripción:<b> Clase que contiene la información de la tabla comic
 * <b>Caso de Uso:<b> Semillero2022
 * @author Estefania
 * @version
 */
@Entity
@Table(name = "COMIC")
public class Comic implements Serializable{
	
	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 216164349106318793L;
	/*
	 * Atributo consecutivo que contine el id
	 * 
	 */
	
	@Id
	@Column(name="SCID")
	@SequenceGenerator(allocationSize = 1, name="COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COMIC_SCID_GENERATOR")
	private Long id;
	/*
	 * Atributo para indicar el nombre del comic
	 */
	@Column(name="SCNOMBRE")
	private String nombre;
	
	/*
	 * Atributo para indicar el nombre de la editorial que publicó el comic
	 */
	@Column(name="SCEDITORIAL")
	private String editorial;
	
	
	/*
	 * Atributo para indicar el tema del comic ( AVENTURAS, BELICO, HUMORISTICO, DEPORTIVO, FANTASTICO, CIENCIA_FICCION', 'HISTORICO', 'HORROR')
	 */
	@Column(name="SCTEMATICA")
	private TematicaEnum tematica;
	
	/*
	 * Atributo que determina el conjunto de publicaciones de la que el comic es parte
	 */
	@Column(name="SCCOLECCION")
	private String coleccion;
	
	/*
	 * Atributo que determina el número de páginas del comic
	 */
	@Column(name="SCNUMEROPAGINAS")
	private Integer numeroPaginas;
	
	/*
	 * Atributo que determina el precio del comic
	 */
	@Column(name="SCPRECIO")
	private BigDecimal precio;
	
	/*
	 * Atributo que determina el autor o los autores del Comic
	 */
	@Column(name="SCAUTORES")
	private String autores;
			
	/*
	 * Atributo para indicar si es a color (true) o blanco y negro (false)
	 */
	@Column(name="SCCOLOR")
	private Boolean color;
	
	/*
	 * Atributo para indicar la fecha de inicio de la venta del comic
	 */
	@Column(name="SCFECHA_VENTA")
	private LocalDate fechaVenta;
	
	
	/*
	 * Atributo que determina si el comic tiene existencia para la venta(activo) o 
	 * no tiene existencia (inactivo)
	 */
	@Column(name = "SCESTADO")
	private EstadoComicEnum estado;
	
	
	/*
	 * Atributo que indica la cantidad de comics que se encuentran disponibles para la enta
	 */
	@Column(name="SCCANTIDAD")
	private Short cantidad;
	
	
	/**
	 * Constructor vacio
	 */
	public Comic() {	
		//Constructor vacío
	}
	
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param nombre Nombre o título del comic
	 * @param editorial Editorial que publicó el comic
	 * @param tematica Permite identificasi el comic es de tipo AVENTURAS, BELICO, HUMORISTICO, DEPORTIVO, FANTASTICO, CIENCIA_FICCION, HISTORICO, HORROR
	 * @param coleccion Conjunto de publicaciones de la que el comic es parte
	 * @param numeroPaginas Numero de paginas que contiene el comic
	 * @param precio Valor en pesos del comic
	 * @param autores Autor o autores del comic
	 * @param color Define si el color es a color (true), blanco y negro (false)
	 * @param fechaVenta Fecha de inicio de la venta del comic
	 * @param estado Indica si el comic tiene existencia para la venta
	 * @param cantidad Define la cantidad de comic se encuentran en inventario
	 */
	public Comic(String nombre, String editorial, TematicaEnum tematica, String coleccion, Integer numeroPaginas,
			BigDecimal precio, String autores, Boolean color, EstadoComicEnum estado,
			Short cantidad) {
		
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematica = tematica;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;		
		this.estado = estado;
		this.cantidad = cantidad;
	}
	

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
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
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoComicEnum getEstado() {
		return estado;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoComicEnum estado) {
		this.estado = estado;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Short getCantidad() {
		return cantidad;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	public TematicaEnum getTematica() {
		return tematica;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(TematicaEnum tematica) {
		this.tematica = tematica;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
	

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", tematica=" + tematica + ", color=" + color
				+ ", fechaVenta=" + fechaVenta + "]";
		
		
	}
	
	
	
	

}
