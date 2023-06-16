package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.models.DispositivoModel;

public interface IDispositivoService {
	
	public List<Dispositivo> getAll();
	public DispositivoModel insertOrUpdate(Dispositivo dispositivo);
	public boolean remove(int id);
	
}
