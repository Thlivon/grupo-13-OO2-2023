package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.Contenedor;

@Repository("contenedorRepository")
public interface IContenedorRepository extends JpaRepository<Contenedor, Serializable> {
	public Contenedor findByIdContenedor(int idContenedor);
	public Contenedor findByLugar(String lugar);

	@Query("SELECT a FROM Contenedor a")
	public List<Contenedor> getAllContenedores();
}

