package com.unla.grupo13OO22023.repositories;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.CamaraAula;
@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {
	public Dispositivo findByIdDispositivo(int idDispositivo);
	
	@Query("SELECT c FROM CamaraAula c")
	public List<CamaraAula> getAllCamaras();
}
