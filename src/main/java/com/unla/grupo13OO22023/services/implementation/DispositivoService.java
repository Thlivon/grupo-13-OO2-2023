package com.unla.grupo13OO22023.services.implementation;

import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.entities.SensorHumedad;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.repositories.IEventoRepository;
import com.unla.grupo13OO22023.repositories.IHabilitacionRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;
import com.unla.grupo13OO22023.services.IEventoService;

import jakarta.transaction.Transactional;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	@Autowired
	@Qualifier("habilitacionRepository")
	private IHabilitacionRepository habilitacionRepository;
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.findByIdDispositivo(idDispositivo);
	}
	@Override
	public Dispositivo getDispositivoYEvento(int idDispositivo) {
		return dispositivoRepository.getDispositivoYEvento(idDispositivo);
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
		
		//Borro la lista de eventos (tambien necesaria para borrar en la bdd)
		//Tengo que recorrer para borrar 1x1 en la base de datos
	    Set<Evento> eventos = findByIdDispositivo(id).getEventos();
		for (Evento evento : eventos) {
            evento.setDispositivo(null);
            eventoRepository.deleteById(evento.getIdEvento()); // Borro el evento especifico de la bdd, al ser un for borro TODOS
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
	
	//Retorna una  lista de un tipo de dispositivos
	public List<Dispositivo> getAllDispositivos(int idHabilitacion){
		return dispositivoRepository.getAllDispositivos(idHabilitacion);
	}
	
	//Cambia el activado de un dispositivo si es posible.
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
	}
	
	
	//TEST DETECCION HOMER - CAMARAAULA
	public void hayAlguien(CamaraAula camara) throws Exception{
		
		if (!(camara.isActivado() && camara.getHabilitado().isHabilitado())) throw new Exception ("El dispositivo no esta en servicio");
		boolean hayAlguien = camara.isHayAlguien();
		
		//strings del evento
		String aux = "La camara detecto a alguien";
		if(hayAlguien) aux ="La camara no detecta a nadie";
		
		//modifico
		camara.setHayAlguien(!hayAlguien);
		camara.getAula().setLucesYcortinas(!hayAlguien);
		
		//guardo el cambio en la bdd
		insertOrUpdate(camara);
		
		//creo el evento
		Evento evento = new Evento(aux,camara);
		camara.getEventos().add(evento);
		eventoService.insertOrUpdate(evento);

	}
	
	//TEST DETECCION BOLBON - SENSORCONTENEDOR
	public void estaLleno(SensorContenedor sensor) throws Exception{
		if (!(sensor.isActivado() && sensor.getHabilitado().isHabilitado())) throw new Exception ("El dispositivo no esta en servicio");
		boolean estaLleno = sensor.isEstaLleno();
		
		//strings del evento
		String aux = "El contenedor está lleno";
		if(estaLleno) aux ="El contenedor se ha vaciado";
		
		//modifico
		sensor.setEstaLleno(!estaLleno);
		
		//guardo el cambio en la bdd
		insertOrUpdate(sensor);
		
		//creo el evento
		Evento evento = new Evento(aux,sensor);
		sensor.getEventos().add(evento);
		eventoService.insertOrUpdate(evento);
	}
	
	//TEST DETECCION BOLBON - SENSORCONTENEDOR
	public void tempBaja(SensorHumedad sensor) throws Exception{
		if (!(sensor.isActivado() && sensor.getHabilitado().isHabilitado())) throw new Exception ("El dispositivo no esta en servicio");
		boolean tempBaja = sensor.isTempBaja();
		
		//strings del evento
		String aux = "Temperatura Baja. Se riega en el pasto";
		if(tempBaja) aux ="Temperatura Normal. Se ha dejado de regar";
		
		//modifico
		sensor.setTempBaja(!tempBaja);
		
		//guardo el cambio en la bdd
		insertOrUpdate(sensor);
		
		//creo el evento
		Evento evento = new Evento(aux,sensor);
		sensor.getEventos().add(evento);
		eventoService.insertOrUpdate(evento);
	}
	
	public void simular(Dispositivo dispositivo) throws Exception{
		if(dispositivo instanceof CamaraAula) { 
			hayAlguien((CamaraAula) dispositivo);
        }
		if(dispositivo instanceof SensorContenedor) { 
			estaLleno((SensorContenedor) dispositivo);
		}
		if(dispositivo instanceof SensorHumedad) { 
			tempBaja((SensorHumedad) dispositivo);
		}
		
	}
}
