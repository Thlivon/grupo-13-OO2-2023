package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.Contenedor;

public interface IContenedorService {
	public List<Contenedor> getAll();
	public Contenedor findByIdContenedor(int idContenedor);
	public Contenedor findByLugar(String lugar);
	public Contenedor insertOrUpdate(Contenedor contenedor);
}
