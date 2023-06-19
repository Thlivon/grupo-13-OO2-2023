package com.unla.grupo13OO22023.cargas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.Contenedor;
import com.unla.grupo13OO22023.entities.EspacioVerde;
import com.unla.grupo13OO22023.repositories.IAulaRepository;
import com.unla.grupo13OO22023.repositories.IContenedorRepository;
import com.unla.grupo13OO22023.repositories.IEspacioVerdeRepository;

@SpringBootTest
public class TestAgregar {

	@Autowired
	private IAulaRepository aulaRepository;
	
	@Autowired
	private IContenedorRepository contenedorRepository;
	
	@Autowired
	private IEspacioVerdeRepository espacioVerdeRepository;
	
	@Test
	public void testAgregar() {
		// Agrega las aulas a la base de datos
		aulaRepository.save(new Aula("Aula roja"));
		aulaRepository.save(new Aula("Aula azul"));
		aulaRepository.save(new Aula("Aula verde"));
		aulaRepository.save(new Aula("Aula amarilla"));
		
		// Agrega los contenedores a la base de datos
		contenedorRepository.save(new Contenedor("Contenedor rojo"));
		contenedorRepository.save(new Contenedor("Contenedor azul"));
		contenedorRepository.save(new Contenedor("Contenedor verde"));
		contenedorRepository.save(new Contenedor("Contenedor amarillo"));
		
		// Agrega los espacios verdes a la base de datos
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector A"));
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector B"));
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector C"));
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector D"));
	}	
}
