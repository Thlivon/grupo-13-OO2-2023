package com.unla.grupo13OO22023.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Component
public class CamaraAulaSimulador {
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	
	@Scheduled(fixedDelay=5000)
	public void runJob() {
		//obtengo lista de camaras creadas del momento
		int aleatorio = (int) (Math.random() * dispositivoRepository.getAllCamaras().size());
		
		if(!dispositivoRepository.getAllCamaras().isEmpty()) {
			try {
				//accedo a una camara ya creada aleatoria y activo la funcion simulando q detecto algo
				CamaraAula camaraAula= dispositivoRepository.getAllCamarasYAtributos().get(aleatorio);
				dispositivoService.hayAlguien(camaraAula);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}
}
