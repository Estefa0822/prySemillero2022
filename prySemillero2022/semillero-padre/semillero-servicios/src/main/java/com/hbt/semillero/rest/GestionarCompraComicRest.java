package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;
import com.hbt.semillero.poo.interfaces.IGestionarCompraComic;

/**
 * 
 * <b>Descripción:<b> Clase que gestiona el servicio de compra de comic 
 * <b>Caso de Uso:<b> SEMILLERO2022TallerFinal
 * @author Estefania Gomez Cardenas
 * @version
 */

@Path("/GestionarCompraComicRest")
public class GestionarCompraComicRest {

	@EJB
	private IGestionarCompraComic gestionarCompraComic;
	
	/**
	 * Metodo encargado de realizar la compra de un comic
	 * <b>Caso de Uso</b>Semillero2022TallerFinal
	 * @author Estefanía Gómez Cárdenas
	 * 
	 * @param comicDTO
	 * @return resultadoDTO
	 */
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO comprarComic(ComicDTO comicDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarCompraComic.comprarComic(comicDTO);
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensaje(e.getMessage());
		}		
		return resultadoDTO;
	}
	
	
}
