package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {
	public Evento findByIdEvento(int idEvento);
	
	
}
