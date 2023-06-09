package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {
	public Evento findByIdEvento(int idEvento);
	public List<Evento> findFirst10ByOrderByFechaYHoraDesc();
	
	@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo d")
	public List<Evento> getAllEventosSinId();
	
	@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo d WHERE d.idDispositivo = :idDispositivo")
    public List<Evento> getAllEventos(@Param("idDispositivo")int idDispositivo);
	
	@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo d WHERE d.habilitado.idHabilitacion = :idHabilitacion")
	public List<Evento> getAllEventosPorTipo(@Param("idHabilitacion") int idHabilitacion);

	
	
}
