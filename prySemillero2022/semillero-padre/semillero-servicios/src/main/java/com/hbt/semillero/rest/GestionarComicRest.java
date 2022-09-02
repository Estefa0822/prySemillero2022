package com.hbt.semillero.rest;



import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:<b> Clase que contiene el catalogo de servicios o APIS que contiene 
 *  la lógica de gestionar un comic o el CRUD
 * <b>Caso de Uso:<b> SEMILLERO2022REST
 * @author Estefania Gomez Cardenas
 * @version
 */

@Path("/gestionarComicRest")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;
	
	/**
	 * 
	 * Metodo encargado del servicio de consultar nombre de precio
	 * <b>Caso de Uso</b>
	 * @author Familia
	 * 
	 * @param idComic Long Identificador del comic
	 * @return
	 */
	@GET
	@Path("/consultarNombrePrecioComic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {		
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}
	
	@Path("/crearComic")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic() {
		
		return null;
	}

}
