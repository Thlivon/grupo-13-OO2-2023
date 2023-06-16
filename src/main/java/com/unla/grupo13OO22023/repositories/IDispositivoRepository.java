package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo13OO22023.entities.Dispositivo;

public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {
	public Dispositivo findByIdDispositivo(int idDispositivo);
}
