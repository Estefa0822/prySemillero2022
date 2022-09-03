package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.dtos.ListarComicTamanioNombreDTO;

public interface IListarComicLocal {

	public ListarComicTamanioNombreDTO consultarComicTamanioNombre(Short tamanio) throws Exception;
}
