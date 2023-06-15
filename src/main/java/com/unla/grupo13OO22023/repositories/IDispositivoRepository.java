package com.unla.grupo13OO22023.repositories;

import com.unla.grupo13OO22023.entities.Dispositivo;

import org.springframework.stereotype.Repository;

@Repository("dispositivoRepository")
public class IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {
	public abstract Dispositivo findByIdDispositivo(int idDispositivo);
	
}
