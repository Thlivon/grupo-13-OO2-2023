package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Contenedor;
import com.unla.grupo13OO22023.repositories.IContenedorRepository;
import com.unla.grupo13OO22023.services.IContenedorService;

@Service("contenedorService")
public class ContenedorService implements IContenedorService{
	@Autowired
	@Qualifier("contenedorRepository")
	private IContenedorRepository contenedorRepository;

	@Override
	public List<Contenedor> getAll() {
		return contenedorRepository.findAll();
	}

	@Override
	public Contenedor findByIdContenedor(int idContenedor) {
		return contenedorRepository.findByIdContenedor(idContenedor);
	}

	@Override
	public Contenedor findByLugar(String lugar) {
		return contenedorRepository.findByLugar(lugar);
	}

	public Contenedor insertOrUpdate(Contenedor contenedor) {
		Contenedor contenedorNuevo = contenedorRepository.save(contenedor);
		return contenedorNuevo;
	}

}
