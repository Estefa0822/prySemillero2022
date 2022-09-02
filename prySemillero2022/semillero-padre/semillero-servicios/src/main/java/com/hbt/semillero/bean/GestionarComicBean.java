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
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dtos(nombre, precio) "
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
		
		try {
			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
			queryConsultaNombrePrecioComic.setParameter("idComic", idComic);
			List <ConsultaNombrePrecioComicDTO> dtoList = queryConsultaNombrePrecioComic.getResultList();
			if (dtoList.isEmpty()) {
				dto.setExitoso(false);
				dto.setMensaje("No existen registros para el comic con id " + idComic);
				return dto;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		LOGGER.info("FINALIZA la ejecucuión de consultarNombrePrecioComic");
		return null;
	}
	
	

}
