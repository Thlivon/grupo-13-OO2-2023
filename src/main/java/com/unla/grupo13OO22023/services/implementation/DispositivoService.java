package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.entities.SensorHumedad;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.findByIdDispositivo(idDispositivo);
	}

	@Override
	public Dispositivo insertOrUpdate(Dispositivo d) {
		Dispositivo dispositivoNuevo = dispositivoRepository.save(d);
		return dispositivoNuevo;
	}

	@Override
	public boolean remove(int id) {
		// Funcion para establecer null a la dependencia (necesario para borrar en la bd)
		if (findByIdDispositivo(id) instanceof CamaraAula) {
			CamaraAula aux = (CamaraAula) findByIdDispositivo(id);
			aux.getAula().setCamara(null);
		}
		if (findByIdDispositivo(id) instanceof SensorContenedor) {
			SensorContenedor aux = (SensorContenedor) findByIdDispositivo(id);
			aux.getContenedor().setSensor(null);
		}
		if (findByIdDispositivo(id) instanceof SensorHumedad) {
			SensorHumedad aux = (SensorHumedad) findByIdDispositivo(id);
			aux.getEspacioVerde().setSenHumedad(null);
		}
		try {
			dispositivoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CamaraAula> getAllCamaras() {
		return dispositivoRepository.getAllCamaras();
	}

	@Override
	public List<SensorContenedor> getAllSensoresContenedor() {
		return dispositivoRepository.getAllSensoresContenedor();
	}
	
	@Override
	public List<SensorHumedad> getAllSensoresHumedad() {
		return dispositivoRepository.getAllSensoresHumedad();
	}
}
