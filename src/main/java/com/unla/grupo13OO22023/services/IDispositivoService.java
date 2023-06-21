package com.unla.grupo13OO22023.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.entities.SensorHumedad;


public interface IDispositivoService {
	public List<Dispositivo> getAll();
	public Dispositivo findByIdDispositivo(int idDispositivo);
	public Dispositivo getDispositivoYEvento(@Param("idDispositivo")int idDispositivo);
	public Dispositivo insertOrUpdate(Dispositivo d);
	public boolean remove(int id);
	
	@ModelAttribute("camaras")
	public List<CamaraAula> getAllCamaras();
	
	@ModelAttribute("sensoresContenedor")
	public List<SensorContenedor> getAllSensoresContenedor();
	
	@ModelAttribute("sensoresHumedad")
	public List<SensorHumedad> getAllSensoresHumedad();
	
	public List<Dispositivo> getAllDispositivos(int idHabilitacion);
	
	public void cambiarActivado(int idActivado, boolean activado);
	
	public void cambiarActivadoSegunHabilitado(int idHabilitacion);
}
