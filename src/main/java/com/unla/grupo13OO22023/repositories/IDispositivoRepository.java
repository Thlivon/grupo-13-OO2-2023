package com.unla.grupo13OO22023.repositories;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.entities.SensorHumedad;

import jakarta.transaction.Transactional;

import com.unla.grupo13OO22023.entities.CamaraAula;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {
	public Dispositivo findByIdDispositivo(int idDispositivo);
	
	@Query("SELECT d FROM Dispositivo d INNER JOIN FETCH d.eventos WHERE d.idDispositivo = :idDispositivo")
	public Dispositivo getDispositivoYEvento(@Param("idDispositivo")int idDispositivo);
	
	@Query("SELECT c FROM CamaraAula c")
	public List<CamaraAula> getAllCamaras();

	@Query("SELECT s FROM SensorContenedor s")
	public List<SensorContenedor> getAllSensoresContenedor();
	
	@Query("SELECT s FROM SensorHumedad s")
	public List<SensorHumedad> getAllSensoresHumedad();
	
	@Query("SELECT d FROM Dispositivo d INNER JOIN FETCH d.habilitado h WHERE h.idHabilitacion = :idHabilitacion")
	public List<Dispositivo> getAllDispositivos(@Param("idHabilitacion")int idHabilitacion);
	
	@Modifying
	@Transactional
	@Query("UPDATE Dispositivo d SET d.activado = :activado WHERE d.idDispositivo = :idDispositivo")
	public void cambiarActivado(@Param("idDispositivo") int idDispositivo, @Param("activado") boolean activado);

}
