package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.EspacioVerde;

public interface IEspacioVerdeService {
	public List<EspacioVerde> getAll();
	public EspacioVerde findByIdEspacioVerde(int idEspacioVerde);
	public EspacioVerde findByLugar(String lugar);
	public EspacioVerde insertOrUpdate(EspacioVerde espacioVerde);
}
