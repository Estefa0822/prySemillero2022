package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 * 
 * <b>Descripción:<b> Clase que contiene os servicios que permiten listar el comic
 * <b>Caso de Uso:<b>Semillero2022TallerRest 
 * @author Estefanía Gómez Cárdenas
 * @version
 */
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ListarComicTamanioNombreDTO;
import com.hbt.semillero.poo.interfaces.IListarComicLocal;
@Path("/listarComic")
public class ListarComicTamanioNombre {
	
	@EJB
	private IListarComicLocal listarComic;
	
	/**
	 * 
	 * Metodo encargado de listar los comics que superan el tamaño del valor ingresado por parámetro
	 * <b>Caso de Uso</b> Semillero2022TallerRest
	 * @author Estefania Gomez Cardenas
	 * 
	 * @param lenghtComic Tamaño para comparar
	 * @return ListarComicTamanioNombreDTO
	 */
	@GET
	@Path("/consultarComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ListarComicTamanioNombreDTO consultarComicTamanioNombre (@QueryParam("lenghtComic") Short lenghtComic) {
		ListarComicTamanioNombreDTO resultado = new ListarComicTamanioNombreDTO();
		try {
			resultado=  listarComic.consultarComicTamanioNombre(lenghtComic);
		} catch (Exception e) {
			resultado.setExitoso(false);
			resultado.setMensaje(e.getMessage());
		}
		return resultado;
	}
	
	
	

}
