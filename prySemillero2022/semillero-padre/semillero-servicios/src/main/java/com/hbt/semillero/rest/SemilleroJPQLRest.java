/**
 * SemilleroJPQLRest.java
 */
package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoComicEnum;
import com.hbt.semillero.enums.TematicaEnum;



/**
 * <b>Descripción:<b> Clase que se encarga de realizar la persistencia de la tabla comic a la base de datos
 * <b>Caso de Uso:<b> 
 * @author Estefania Gomez Cardenas
 * @version 1.0
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class SemilleroJPQLRest {

	/**
	 * Constante que contendrá el log de la clase AritmeticaTest
	 */
	private final static Logger LOG = Logger.getLogger(SemilleroJPQLRest.class);
	//La anotación nos sirve para inicializar el entity manager
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String generarOperacionComic() {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		LOG.info("Se ejecuta generarOperacionComic()");
		
		Comic comic;
		
		try { //Se vuelve suceptible a los errores, por lo cual se de controlar 
			// ++++++++ 2 Formas de hacerlo
			
			//Entity Manager
			// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
			// SELECT * FROM COMIC WHERE ID = 15;

//			comic = em.find(Comic.class, 2L);
////			LOG.info("DATA COMIC" + comic.toString());
//			
//			//JPQL
//			//Consulta JPQL es más precisa
//			String consulta = "SELECT c FROM Comic c WHERE c.id = 1 ";
//			Query queryUnComic = em.createQuery(consulta); //Se crea consulta JPQL, y se almacena en queryUnComic
//			comic = (Comic) queryUnComic.getSingleResult();	//Ejecuta el query y obtiene el resultado... se obtiene object por lo cual se debe castear a comic
//			
//			
//			//Consulta JPQL para obtener un comic
//			String consulta2 = "SELECT cm FROM Comic cm "
//					+ " WHERE  cm.tematicaEnum='AVENTURAS'"
//					+ " AND cm.id = 2 "
//					+ " AND cm.color = false "
//					+ " AND CM.estadoEnum='ACTIVO'";
//			Query queryUnComicDos = em.createQuery(consulta2);
//			comic = (Comic) queryUnComicDos.getSingleResult();
//			
//			//Consulta JPQL para obtener un comic
//			String consulta3 = "SELECT cm FROM Comic cm "
//					+ " WHERE  cm.tematicaEnum='AVENTURAS'"
//					+ " AND cm.id = :idComic "
//					+ " AND cm.tematicaEnum = :tematicaEnum " 
//					+ " AND cm.color = :color "
//					+ " AND CM.estadoEnum= :estado";
//			Query queryUnComicTres = em.createQuery(consulta3);
//			//Le pasamos los parámetros que definimos más arriba en la consulta
//			//Se encapsula la información
//			
//			queryUnComicTres.setParameter("idComic", comic.getId());
//			queryUnComicTres.setParameter("tematicaEnum", TematicaEnum.AVENTURAS);
//			queryUnComicTres.setParameter("color", Boolean.FALSE);
//			queryUnComicTres.setParameter("estado", EstadoComicEnum.ACTIVO);
//			
//			comic = (Comic) queryUnComicTres.getSingleResult();
//			
//			//GENERA ERROR
//					
//			//Query que genera una excepción de tipo NoResultException
//			//Consulta JPQL para obtener un comic
////			String consulta4 = "SELECT cm FROM Comic cm "
////					+ " WHERE  cm.tematicaEnum='AVENTURAS'"
////					+ " AND cm.id = :idComic "
////					+ " AND cm.tematicaEnum = :tematicaEnum " 
////					+ " AND cm.color = :color "
////					+ " AND CM.estadoEnum= :estado";
//			
//			//Query queryUnComicCuatro = em.createQuery(consulta2);
//			//queryUnComicCuatro.setParameter("idComic", comic.getId());
//			//queryUnComicCuatro.setParameter("tematicaEnum", TematicaEnum.HORROR);
//			//queryUnComicCuatro.setParameter("color", Boolean.FALSE);
//			//queryUnComicCuatro.setParameter("estado", EstadoComicEnum.INACTIVO);
//			
//			//comic = (Comic) queryUnComicCuatro.getSingleResult();
//			
//			//Query que retorna una lista de datos
//			String consultaListaComics = "SELECT cm FROM Comic cm "
//					+ " WHERE cm.tematicaEnum = :tematicaEnum "
//					+ " AND cm.color = :colorComic ";
//			Query queryListaComics = em.createQuery(consultaListaComics);
//			queryListaComics.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
//			queryListaComics.setParameter("colorComic", Boolean.TRUE);
//			List <Comic> listaComics = queryListaComics.getResultList();
//			
//			for (Comic comicList : listaComics) {
//				LOG.info("+++++++++++++++++++++++++++++++++++++++++++++");
//				LOG.info("DATA COMIC "+ comicList.toString());	
//				System.out.println("DATA COMIC " + comicList.toString());
//			}
//			
//			//QUERY QUE GENERA ERROR PORQUE DEVUELVE MÁS DE UN DATO Y LO ESTOY EJECUTANDO CON GetSingleResult
////			String consultaListaNonUnique = "SELECT cm FROM Comic cm "
////					+ " WHERE cm.tematicaEnum = :tematicaEnum "
////					+ " AND cm.color = :colorComic ";
////			Query queryNonUnique = em.createQuery(consultaListaNonUnique);
////			queryNonUnique.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
////			queryNonUnique.setParameter("colorComic", Boolean.FALSE);
////			comic = (Comic) queryNonUnique.getSingleResult(); //Genera error porque trae mas de un dato
			
			
			//SE CREA UN COMIC
			Comic comicThor = new Comic();
			comicThor.setNombre("La abejita magica");
			comicThor.setEditorial("editorial sa.");
			comicThor.setColeccion("las aventuras de abeja");
			comicThor.setNumeroPaginas(12);
			comicThor.setPrecio(new BigDecimal(1200));
			comicThor.setEstadoEnum(EstadoComicEnum.ACTIVO);
			comicThor.setCantidad((short)5);
			
			//INSERT
			em.persist(comicThor); 
			
			
			//RETORNAR UN COMIC DE LA BASE A JAVA
			comic = em.find(Comic.class, 1L);
			
			//Modifico algunos cambios en Java
			comicThor.setColor(Boolean.FALSE);
			comicThor.setFechaVenta(LocalDate.now());
			
			//Actualizo en la base de datos
			em.merge(comicThor);
			
			//ELIMINO EL COMIC INDICADO
			//TAREA VERIFICAR QUE SI VALIDA
			if (comic !=null) {
			em.remove(comic);
			}
			
			
			
			//JPQL
			int recordUpdate;
			
			String actualizarComic = "UPDATE Comic c SET c.estadoEnum = :estadoEnum"
					+ " WHERE c.id= :idComic ";
			Query queryActualizarComic= em.createQuery(actualizarComic);
			queryActualizarComic.setParameter("estadoEnum", EstadoComicEnum.INACTIVO);
			queryActualizarComic.setParameter("idComic", 8L);
			recordUpdate= queryActualizarComic.executeUpdate();
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
			LOG.info("Se actualizaron " + recordUpdate  + " registros");
//			
//			
//			//ELIMINAR CON JPQL
//			String eliminarComic = "DELETE FROM Comic "
//					+ " WHERE id IN( :idsComics)";
//			Query queryEliminarComics = em.createQuery(eliminarComic);
//			
//			//se elimina el id 2 y 5
//			queryEliminarComics.setParameter("", Arrays.asList(2L, 5L));
//			recordUpdate= queryEliminarComics.executeUpdate();
//			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
//			LOG.info("Se eliminaron " + recordUpdate  + " registros");
//						
//			//Consultar campos especificos de una forma casi manual
//			String consultaCampos = "SELECT c.nombre, c.estadoEnum "
//									+ "FROM Comic c "
//									+ " WHERE c.id = :idComic ";
//			Query queryCampos = em.createQuery(consultaCampos);
//			queryCampos.setParameter("idComic", 1L);
//			Object[] data = (Object []) queryCampos.getSingleResult();
//			String nombre = (String) data[0];
//			EstadoComicEnum estadoEnum = (EstadoComicEnum) data[1];
//			BigDecimal precio = data[2]!=null ? (BigDecimal) data[2]: null;
//			
//			ComicDTO dto = new ComicDTO();
//			dto.setNombre(nombre);
//			dto.setEstadoEnum(estadoEnum);
//			dto.setPrecio(precio);
//			
//			//Consulta de campos especificos de forma más moderna
//			String consultaCamposConstructor = "SELECT new com.hbt.semillero.dtos.ComicDTO(c.nombre, c.estadoEnum, c.precio )"
//					+ "	FROM Comic c "
//					+ " WHERE c.id = :idComic ";
//			Query queryCamposConstructor = em.createQuery(consultaCamposConstructor);
//			queryCamposConstructor.setParameter("idComic", 1L);
//			ComicDTO comicDTO = (ComicDTO) queryCamposConstructor.getSingleResult();
//			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
//			LOG.info("DATA DTO "  + comicDTO.toString());
//			
//			//CONSULTA DE FORMA NATIVA
//			//Sql de forma nativa, se consulta la tabla comic de la base de datos
//			//Es más rápida
//			String consultaNative = "SELECT new com.hbt.semillero.dtos.ComicDTO(SCNOMBRE, SCESTADO, SCPRECIO) "
//					+ " FROM COMIC c"
//					+ " WHERE c.SCID = :idComic";
//			Query queryNativo = em.createNativeQuery(consultaNative);
//			queryNativo.setParameter("idParametros", 1L);
//			ComicDTO comicDTONative = (ComicDTO) queryNativo.getSingleResult();
//			
//			//Paginacion por base de datos
//			String consultaPaginada = "SELECT new com.hbt.semillero.dtos.ComicDTO(c.nombre, c.estadoEnum, c.precio) "
//					+ " FROM Comic c"
//					+ " ORDER BY c.nombre ASC ";
//			Query queryPaginado = em.createQuery(consultaPaginada);
//			queryPaginado.setParameter("idComic", 9L);
//			queryPaginado.setFirstResult(11);
//			queryPaginado.setMaxResults(15);
						
			
		} catch (NonUniqueResultException nure) {
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
			LOG.error("Se ha presentado duplicidad de datos con el id 15" + nure.getMessage());
			System.out.println("Se ha presentado error de duplicidad: " + nure.getMessage());
		}catch(NoResultException nre){
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
			LOG.error("No se encontró registros para el id 15" + nre.getMessage());
			System.out.println("No se encontró registros " + nre.getMessage());
		}catch (Exception e) {
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			LOG.error("Se ha presentado un error técnico" + e.getMessage());
			System.out.println("Se ha presentado un error técnico " + e.getMessage());
		}
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		LOG.info("Finaliza generarOperacionComic()");
		return "";
	}
	
}
