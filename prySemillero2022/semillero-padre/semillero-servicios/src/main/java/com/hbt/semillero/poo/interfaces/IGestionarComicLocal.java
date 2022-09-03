package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ListarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

public interface IGestionarComicLocal {

	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	public ResultadoDTO modificarComic(ComicDTO comicDTO) throws Exception;
	
	
	
}
