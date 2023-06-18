package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.repositories.IAulaRepository;
import com.unla.grupo13OO22023.services.IAulaService;

@Service("aulaService")
public class AulaService implements IAulaService {
	@Autowired
	@Qualifier("aulaRepository")
	private IAulaRepository aulaRepository;

	@Override
	public List<Aula> getAll() {
		return aulaRepository.findAll();
	}

	@Override
	public Aula findByIdAula(int idAula) {
		return aulaRepository.findByIdAula(idAula);
	}

	@Override
	public Aula findByLugar(String lugar) {
		return aulaRepository.findByLugar(lugar);
	}

	public Aula insertOrUpdate(Aula aula) {
		Aula aulaNueva = aulaRepository.save(aula);
		return aulaNueva;
	}
}
