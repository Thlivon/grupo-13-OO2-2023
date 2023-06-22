package com.unla.grupo13OO22023.cargas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo13OO22023.entities.Contenedor;
import com.unla.grupo13OO22023.repositories.IContenedorRepository;

@SpringBootTest
public class agregarContenedores {
	@Autowired
	private IContenedorRepository contenedorRepository;

	@Test
	public void testAgregarContenedor() {

		// Agrega aulas a la base de datos
		contenedorRepository.save(new Contenedor("Contenedor rojo"));
		contenedorRepository.save(new Contenedor("Contenedor azul"));
		contenedorRepository.save(new Contenedor("Contenedor verde"));
		contenedorRepository.save(new Contenedor("Contenedor amarillo"));
	}
}
