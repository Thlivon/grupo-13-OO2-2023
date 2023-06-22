package com.unla.grupo13OO22023.cargas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo13OO22023.entities.EspacioVerde;
import com.unla.grupo13OO22023.repositories.IEspacioVerdeRepository;

@SpringBootTest
public class agregarEspacioVerde {
	@Autowired
	private IEspacioVerdeRepository espacioVerdeRepository;

	@Test
	public void testAgregarEspacioVerde() {
		// Agrega los espacios verdes a la base de datos
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector A"));
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector B"));
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector C"));
		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector D"));
	}
	
}
