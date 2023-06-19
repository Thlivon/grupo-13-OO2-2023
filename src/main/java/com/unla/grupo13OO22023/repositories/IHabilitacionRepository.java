package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Habilitacion;

@Repository("habilitacionRepository")
public interface IHabilitacionRepository extends JpaRepository<Habilitacion, Serializable>{
	Habilitacion findByIdHabilitacion(int idHabilitacion);
	Habilitacion findByNombre(String nombre);
	@Query("SELECT h FROM Habilitacion h")
	public List<Habilitacion> getAllHabilitaciones();
}
