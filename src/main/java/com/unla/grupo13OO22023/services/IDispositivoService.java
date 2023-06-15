package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.Dispositivo;

public interface IDispositivoService {
	
	public List<Dispositivo> getAll();
	public boolean remove(int id);
	
}
