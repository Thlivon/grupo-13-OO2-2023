package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.models.DispositivoModel;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	public DispositivoModel insertOrUpdate(Dispositivo dispositivo) {
		Dispositivo dispositivoNew = dispositivoRepository.save(dispositivo);
		return modelMapper.map(dispositivoNew, DispositivoModel.class);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			dispositivoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


}
