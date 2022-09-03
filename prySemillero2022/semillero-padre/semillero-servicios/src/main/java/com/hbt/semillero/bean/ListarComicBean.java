package com.hbt.semillero.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.query.criteria.internal.expression.function.LengthFunction;

import com.hbt.semillero.dtos.ListarComicTamanioNombreDTO;
import com.hbt.semillero.poo.interfaces.IListarComicLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ListarComicBean implements IListarComicLocal {

	private final static Logger LOGGER = Logger.getLogger(GestionarComicBean.class);
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo encargado de consultar todos los comic en la base de datos y 
	 * clasificarlos en dos listas según su tamaño 
	 * <b>Caso de Uso</b>
	 * @param tamanio Short Tamaño con el cual se va a realizar la comparación
	 * @return ListarComicTamanioNombreDTO
	 */
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ListarComicTamanioNombreDTO consultarComicTamanioNombre(Short tamanio) throws Exception {
		ListarComicTamanioNombreDTO dto = new ListarComicTamanioNombreDTO();
		if (tamanio > 13) {
			throw new Exception("La longitud maxima permitida es de 12 caracteres");
		}
		LOGGER.info("Inicia la ejecución de consultarTamanioNombre");
		
		String listarComics = "SELECT nombre  "
							+ "FROM Comic ";
		Query queryListaComics = em.createQuery(listarComics);
		List<String> listaComics = queryListaComics.getResultList();
		for (String nombreComic : listaComics) {
			if(nombreComic.length()> tamanio) {
				
				dto.addComicSuperaTamanio(nombreComic);
			}else {
				dto.addComicNoSuperaTamanio(nombreComic);
			}
		}
		dto.setExitoso(true);
		dto.setMensaje("Comics procesados exitosamente");		
		LOGGER.info("Finaliza la ejecución de consultarTamanioNombre");		
		return dto;
	}

	
	

}
