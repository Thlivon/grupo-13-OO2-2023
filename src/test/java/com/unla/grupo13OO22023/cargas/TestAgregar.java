package com.unla.grupo13OO22023.cargas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Contenedor;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.EspacioVerde;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.repositories.IAulaRepository;
import com.unla.grupo13OO22023.repositories.IContenedorRepository;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.repositories.IEspacioVerdeRepository;
import com.unla.grupo13OO22023.repositories.IHabilitacionRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;

@SpringBootTest
public class TestAgregar {

	@Autowired
	private IAulaRepository aulaRepository;
	
	@Autowired
	private IContenedorRepository contenedorRepository;
	
	@Autowired
	private IEspacioVerdeRepository espacioVerdeRepository;
	
	@Autowired
	private IHabilitacionRepository habilitacionRepository;
	
	@Autowired
	private IDispositivoRepository dispositivoRepository;
	
	@Autowired
	private IDispositivoService dispositivoService;
	
	@Test
	public void testAgregar() {
//		// Agrega las aulas a la base de datos
//		aulaRepository.save(new Aula("Aula roja"));
//		aulaRepository.save(new Aula("Aula azul"));
//		aulaRepository.save(new Aula("Aula verde"));
//		aulaRepository.save(new Aula("Aula amarilla"));
//		
//		// Agrega los contenedores a la base de datos
//		contenedorRepository.save(new Contenedor("Contenedor rojo"));
//		contenedorRepository.save(new Contenedor("Contenedor azul"));
//		contenedorRepository.save(new Contenedor("Contenedor verde"));
//		contenedorRepository.save(new Contenedor("Contenedor amarillo"));
//		
//		// Agrega los espacios verdes a la base de datos
//		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector A"));
//		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector B"));
//		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector C"));
//		espacioVerdeRepository.save(new EspacioVerde("Espacio Verde Sector D"));
//		
//		//Agrega los 3 tipos de dispositivo (Habilitar)
//		habilitacionRepository.save(new Habilitacion("Habilitacion Camaras"));
//		habilitacionRepository.save(new Habilitacion("Habilitacion Sensores Contenedor"));
//		habilitacionRepository.save(new Habilitacion("Habilitacion Sensores Humedad"));
		
		
//		//obtengo lista de camaras creadas del momento
//		int aleatorio = (int) (Math.random() * dispositivoRepository.getAllCamarasYAtributos().size());
//		
//		//accedo a una camara ya creada aleatoria y activo la funcion simulando q detecto algo
//		CamaraAula camaraAula= dispositivoRepository.getAllCamarasYAtributos().get(0);
//		dispositivoService.hayAlguien(camaraAula);
		
	}	
}
