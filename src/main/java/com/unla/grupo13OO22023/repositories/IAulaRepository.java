package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Aula;

@Repository("aulaRepository")
public interface IAulaRepository extends JpaRepository<Aula, Serializable> {
	public Aula findByIdAula(int idAula);

	@Query("SELECT a FROM Aula a")
	public List<Aula> getAllAulas();
}
