package com.unla.grupo13OO22023.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Evento;

public interface IEventoService {
	public List<Evento> getAll();
	public Evento findByIdEvento(int idEvento);
	public Evento insertOrUpdate(Evento e);
	
	public List<Evento> getAllEventos(int idDispositivo);
}