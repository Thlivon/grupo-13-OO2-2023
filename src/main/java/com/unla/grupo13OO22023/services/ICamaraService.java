package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.models.CamaraModel;

public interface ICamaraService {
	public List<CamaraAula> getAll();
	public CamaraModel insertOrUpdate(CamaraAula dispositivo);
	public boolean remove(int id);
}
