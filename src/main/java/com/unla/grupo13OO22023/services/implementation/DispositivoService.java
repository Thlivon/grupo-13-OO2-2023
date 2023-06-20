package com.unla.grupo13OO22023.services.implementation;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.entities.SensorHumedad;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.repositories.IHabilitacionRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;

import jakarta.transaction.Transactional;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	@Autowired
	@Qualifier("habilitacionRepository")
	private IHabilitacionRepository habilitacionRepository;

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
		// Funcion para establecer null a la dependencia (necesario para borrar en la
		// bd)
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
	
	public List<Dispositivo> getAllDispositivos(int idHabilitacion){
		return dispositivoRepository.getAllDispositivos(idHabilitacion);
	}

	@Transactional
	public void cambiarActivado(int idDispositivo, boolean activado) {
		Dispositivo dispositivo = dispositivoRepository.findByIdDispositivo(idDispositivo);
		if (dispositivo != null) {
			dispositivoRepository.cambiarActivado(idDispositivo, activado);
		}
	}
	
	// CAMBIA EL ATRIBUTO ACTIVADO DE LOS DISPOSITIVOS DE UN TIPO ESPECIFICO
	// (idHabilitado) A FALSE
	public void cambiarActivadoSegunHabilitado(int idHabilitacion) {
		List<Dispositivo> lista = getAllDispositivos(idHabilitacion);
				
		for (int i = 0; i < lista.size(); i++) {
			cambiarActivado(lista.get(i).getIdDispositivo(), false);
		}
//		 switch (idHabilitacion) {
//	        case 1:
//	            lista = new ArrayList<Dispositivo>(getAllCamaras());
//	            break;
//	        case 2:
//	            lista = new ArrayList<Dispositivo>(getAllSensoresContenedor());
//	            break;
//	        case 3:
//	            lista = new ArrayList<Dispositivo>(getAllSensoresHumedad());
//	            break;
////	    }
	}
	
}
