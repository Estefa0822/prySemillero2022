package com.hbt.semillero.bean;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoComicEnum;
import com.hbt.semillero.poo.interfaces.IGestionarCompraComic;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {

	
	private final static Logger LOGGER = Logger.getLogger(GestionarComicBean.class);
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo encargado de realizar la compra de un comic a nivel de base de datos 
	 * <b>Caso de Uso</b>Semillero2022TallerFinal
	 * @author Estefania Gomez Cardenas 
	 * @param idComic Long identificador del comic
	 * @return ResultadoDTO
	 * @throws Exception 
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO comprarComic(ComicDTO comicDto) throws Exception {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		//El proceso de compra se realiza con el id
		if (comicDto.getId() == null ) {
			throw new Exception("El campo id es requerido");
		}
		//Realiza la consulta la base de datos con el id
		Comic comicActual = em.find(Comic.class, comicDto.getId());
		if (comicActual ==null) {
			throw new Exception("No se encuentra el comic a comprar");
		}
		//Verifica que no se encuentre en estado inactivo
		if (comicActual.getEstadoEnum()== EstadoComicEnum.INACTIVO) {
			throw new Exception("El comic seleccionado no cuenta con Stock en bodega");
		}
		//Verifica que la cantidad ingresada no sea superior a la cantidad disponible
		if (comicActual.getCantidad()< comicDto.getCantidad()) {
			throw new Exception("La cantidad existente del comic es " + comicActual.getCantidad() + " y supera la ingresada");
		}
		
		//Inicia el proceso de compra
		
		short cantidadNueva= (short) (comicActual.getCantidad() - comicDto.getCantidad());
		
		comicActual.setCantidad(cantidadNueva); //configura la nueva cantidad
		if (cantidadNueva == 0) {
			comicActual.setEstadoEnum(EstadoComicEnum.INACTIVO);
		}
		//comicActual.setFechaVenta(comicDto.getFechaVenta());
		comicActual.setFechaVenta(LocalDate.now());
		
		
		em.merge(comicActual);
		resultadoDTO.setExitoso(true);
		resultadoDTO.setMensaje("La compra del comic " + comicActual.getNombre() + " fue exitosa");
		LOGGER.info("Se registra correctamente compra de comic id " + comicDto.getId());		
				
		return resultadoDTO;
	}
	

}
