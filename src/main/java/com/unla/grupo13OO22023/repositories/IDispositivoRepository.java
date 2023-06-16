package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Dispositivo;
@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {
	public Dispositivo findByIdDispositivo(int idDispositivo);
}
