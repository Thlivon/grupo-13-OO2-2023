package com.unla.grupo13OO22023.services;

import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Evento;

public interface IEventoService {
	public Evento findByIdEvento(int idEvento);
	public Evento insertOrUpdate(Evento e);
}
