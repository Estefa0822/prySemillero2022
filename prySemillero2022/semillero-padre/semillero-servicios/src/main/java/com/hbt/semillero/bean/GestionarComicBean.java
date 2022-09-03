package com.hbt.semillero.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> Semillero2022Rest
 * @author Estefania Gómez Cardenas
 * @version
 */

// @Stateless = Cada transaccion de manera autónoma

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {
	
	private final static Logger LOGGER = Logger.getLogger(GestionarComicBean.class);
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * Metodo encargado de ejecutar 
	 * <b>Caso de Uso</b>
	 * @author Estefania Gomez Cardenas 
	 * @param idComic Long identificador del comic
	 * @return
	 */
	
	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {		
		LOGGER.info("Inicia la ejecucuión de consultarNombrePrecioComic");
		ConsultaNombrePrecioComicDTO dto = new ConsultaNombrePrecioComicDTO();
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO(nombre, precio) "
											+ "FROM Comic "
											+ "WHERE id= :idComic";
		try {
			Query queryConsultarNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
			queryConsultarNombrePrecioComic.setParameter("idComic", idComic);
			dto = (ConsultaNombrePrecioComicDTO) queryConsultarNombrePrecioComic.getSingleResult();
			dto.setExitoso(true);
			dto.setMensaje("Se ha ejecutado exitosamente");
						
		} catch (NonUniqueResultException nur) {
			
			LOGGER.info("Se encontraron registros duplicados: " + nur.getMessage());
			dto.setExitoso(false);
			dto.setMensaje("Se encontraron registros duplicados para el id " + idComic);
		} catch(NoResultException nre) {
			LOGGER.info("No se encontraron registros para el id " + nre.getMessage());
			dto.setExitoso(false);
			dto.setMensaje("No existen registros para el comic con id " + idComic);
			
		} catch (Exception e) {
			LOGGER.error("Se ha presentado un error técnico " + e.getMessage());
			dto.setExitoso(false);
			dto.setMensaje("sE PRESENTÓ ERROR TÉCNICO  " + idComic);
		}
		
		
		//FORMA 2
		
//		try {
//			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
//			queryConsultaNombrePrecioComic.setParameter("idComic", idComic);
//			List <ConsultaNombrePrecioComicDTO> dtoList = queryConsultaNombrePrecioComic.getResultList();
//			if (dtoList.isEmpty()) {
//				dto.setExitoso(false);
//				dto.setMensaje("No existen registros para el comic con id " + idComic);
//				return dto;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
		
		
		LOGGER.info("FINALIZA la ejecucuión de consultarNombrePrecioComic");
		return dto;
	}
	
	/**
	 * Método encargado de crear un comic en la base de datos apartir de un DTO
	 * @return resultadoDTO 
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception {
		if (comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		resultadoDTO.setMensaje("El comic ha sido creado exitosamente");
		
		return resultadoDTO;
	}
	
	/**
	 * Método encargado de realizar la modificación de todos los datos de un comic, según el id ingresado
	 * 
	 */
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO modificarComic(ComicDTO comicDTO) throws Exception {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		if (comicDTO.getId() == null) {
			throw new Exception("El campo id es requerido");
		}
		LOGGER.info("Se va a actualizar la información relacionada al comic " + comicDTO.getId());
		//Busca el comic por id en la base de datos
		Comic comicAct = em.find(Comic.class, comicDTO.getId());
		if (comicAct !=null) {
			//Modifica los campos con los nuevos datos
			comicAct.setNombre(comicDTO.getNombre());
			comicAct.setEditorial(comicDTO.getEditorial());			
			comicAct.setColeccion(comicDTO.getColeccion());
			comicAct.setNumeroPaginas(comicDTO.getNumeroPaginas());
//			comicAct.setPrecio(comicDTO.getPrecio());			
			comicAct.setAutores(comicDTO.getAutores());
			
			comicAct.setTematica(comicDTO.getTematicaEnum());
			
//			comicAct.setColor(comicDTO.getColor());
//			comicAct.setFechaVenta(comicDTO.getFechaVenta());
			comicAct.setEstadoEnum(comicDTO.getEstadoEnum());
//			comicAct.setCantidad(comicDTO.getCantidad());
			em.merge(comicAct);
						
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensaje("El comic ha sido modificado exitosamente");
			
		}else {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensaje("No se encuentra el comic con id " + comicDTO.getId());
		}
		return resultadoDTO;
		
	}
	
	/**
	 * 
	 * Metodo encargado de  convertir un comicDTO en un comic
	 * <b>Caso de Uso</b> semillero2022
	 * @author Estefania Gomez Cardenas	 * 
	 * @param comicDTO que contiene los datos para convertir
	 * @return Comic
	 */
	
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematica(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		
		return comic;
	}
	
	

}
