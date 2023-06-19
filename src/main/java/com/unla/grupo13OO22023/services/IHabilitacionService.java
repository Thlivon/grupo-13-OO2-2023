package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.Habilitacion;

public interface IHabilitacionService {
	public List<Habilitacion> getAll();
	public Habilitacion findByIdHabilitacion(int idHabilitacion);
	public Habilitacion findByNombre(String nombre);
	public Habilitacion insertOrUpdate(Habilitacion h);
}
