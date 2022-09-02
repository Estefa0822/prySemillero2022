package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;

public interface IGestionarComicLocal {

	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
}
