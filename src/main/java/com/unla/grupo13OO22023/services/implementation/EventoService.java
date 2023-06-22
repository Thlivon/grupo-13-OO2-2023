package com.unla.grupo13OO22023.services.implementation;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.repositories.IEventoRepository;
import com.unla.grupo13OO22023.repositories.IHabilitacionRepository;
import com.unla.grupo13OO22023.services.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService {
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	@Autowired
	@Qualifier("habilitacionRepository")
	private IHabilitacionRepository habilitacionRepository;
	
	@Override
	public List<Evento> getAll(){
		return eventoRepository.findAll();
	}

	@Override
	public Evento findByIdEvento(int idEvento) {
		return eventoRepository.findByIdEvento(idEvento);
	}
	@Override
	public Evento insertOrUpdate(Evento e) {
		Evento eventoNuevo = eventoRepository.save(e);
		return eventoNuevo;
	}
	
	public List<Evento> getAllEventos(int idDispositivo){
		return eventoRepository.getAllEventos(idDispositivo);
	}
	
	public List<Evento> getAllEventosPorTipo(int idHabilitacion){
		return eventoRepository.getAllEventosPorTipo(idHabilitacion);
	}
}
