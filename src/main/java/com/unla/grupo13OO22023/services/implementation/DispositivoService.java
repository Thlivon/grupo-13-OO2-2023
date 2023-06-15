package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {

	@Override
	public List<Dispositivo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
