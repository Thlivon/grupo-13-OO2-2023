package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;

import com.unla.grupo13OO22023.entities.Dispositivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {
	public abstract Dispositivo findByIdDispositivo(int idDispositivo);
	
}
