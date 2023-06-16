package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo13OO22023.entities.CamaraAula;

public interface ICamaraRepository extends JpaRepository<CamaraAula, Serializable> {
	public abstract CamaraAula findByIdCamaraAula(int idCamaraAula);
}
