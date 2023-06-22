package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.EspacioVerde;
import com.unla.grupo13OO22023.repositories.IEspacioVerdeRepository;
import com.unla.grupo13OO22023.services.IEspacioVerdeService;

@Service("espacioVerdeService")
public class EspacioVerdeService implements IEspacioVerdeService {
	@Autowired
	@Qualifier("espacioVerdeRepository")
	private IEspacioVerdeRepository espacioVerdeRepository;

	@Override
	public List<EspacioVerde> getAll() {
		return espacioVerdeRepository.findAll();
	}

	@Override
	public EspacioVerde findByIdEspacioVerde(int idEspacioVerde) {
		return espacioVerdeRepository.findByIdEspacioVerde(idEspacioVerde);
	}

	@Override
	public EspacioVerde findByLugar(String lugar) {
		return espacioVerdeRepository.findByLugar(lugar);
	}

	public EspacioVerde insertOrUpdate(EspacioVerde espacioVerde) {
		EspacioVerde espacioVerdeNuevo = espacioVerdeRepository.save(espacioVerde);
		return espacioVerdeNuevo;
	}
}
