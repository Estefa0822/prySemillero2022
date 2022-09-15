package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

public interface IGestionarCompraComic {
	
	public ResultadoDTO comprarComic(ComicDTO comicDto) throws Exception;

}
