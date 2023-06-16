package com.unla.grupo13OO22023.services;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.SensorContenedor;


public interface IDispositivoService {
	public List<Dispositivo> getAll();
	public Dispositivo findByIdDispositivo(int idDispositivo);
	public Dispositivo insertOrUpdate(Dispositivo d);
	public boolean remove(int id);
	
	@ModelAttribute("camaras")
	public List<CamaraAula> getAllCamaras();
	
	@ModelAttribute("sensoresContenedor")
	public List<SensorContenedor> getAllSensoresContenedor();
}
