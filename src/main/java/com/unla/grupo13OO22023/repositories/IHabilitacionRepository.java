package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Habilitacion;

import jakarta.transaction.Transactional;

@Repository("habilitacionRepository")
public interface IHabilitacionRepository extends JpaRepository<Habilitacion, Serializable>{
	public Habilitacion findByIdHabilitacion(int idHabilitacion);
	public Habilitacion findByNombre(String nombre);
	
	@Modifying
	@Transactional
	@Query("UPDATE Habilitacion h SET h.habilitado = :habilitado WHERE h.idHabilitacion = :idHabilitacion")
	public void cambiarHabilitacion(@Param("idHabilitacion") int idHabilitacion, @Param("habilitado") boolean habilitado);
	
	@Query("SELECT h FROM Habilitacion h")
	public List<Habilitacion> getAllHabilitaciones();
}
