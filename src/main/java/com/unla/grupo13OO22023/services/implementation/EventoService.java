package com.unla.grupo13OO22023.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.repositories.IEventoRepository;
import com.unla.grupo13OO22023.services.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService {
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Override
	public Evento findByIdEvento(int idEvento) {
		return eventoRepository.findByIdEvento(idEvento);
	}
	@Override
	public Evento insertOrUpdate(Evento e) {
		Evento eventoNuevo = eventoRepository.save(e);
		return eventoNuevo;
	}
}
