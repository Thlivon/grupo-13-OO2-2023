package com.unla.grupo13OO22023.services;

import java.util.List;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.Dispositivo;

public interface IAulaService {
	public List<Aula> getAll();
	public Aula findByIdAula(int idAula);
	public Aula findByLugar(String lugar);
	public Aula insertOrUpdate(Aula aula);
}
