package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.repositories.IHabilitacionRepository;
import com.unla.grupo13OO22023.services.IHabilitacionService;
@Service("habilitacionService")
public class HabilitacionService implements IHabilitacionService{
	@Autowired
	@Qualifier("habilitacionRepository")
	private IHabilitacionRepository habilitacionRepository;
	
	@Override
	public List<Habilitacion> getAll(){
		return habilitacionRepository.findAll();
	}
	
	@Override
	public Habilitacion findByIdHabilitacion(int idHabilitacion) {
		return habilitacionRepository.findByIdHabilitacion(idHabilitacion);
	}
	
	@Override
	public Habilitacion findByNombre(String nombre) {
		return habilitacionRepository.findByNombre(nombre);
	}
	
	@Override
	public Habilitacion insertOrUpdate(Habilitacion h) {
		Habilitacion habilitacionNueva = habilitacionRepository.save(h);
		return habilitacionNueva;
		
	}

	
}
