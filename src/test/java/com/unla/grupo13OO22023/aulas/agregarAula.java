package com.unla.grupo13OO22023.aulas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.repositories.IAulaRepository;

@SpringBootTest
public class agregarAula {
	@Autowired
	private IAulaRepository aulaRepository;

	@Test
	public void testAgregarAula() {

		// Agrega aulas a la base de datos
		aulaRepository.save(new Aula("Aula roja"));
		aulaRepository.save(new Aula("Aula azul"));
		aulaRepository.save(new Aula("Aula verde"));
		aulaRepository.save(new Aula("Aula amarilla"));
	}
}
