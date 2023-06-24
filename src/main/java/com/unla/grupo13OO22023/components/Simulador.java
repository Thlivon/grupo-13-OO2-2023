package com.unla.grupo13OO22023.components;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.repositories.IDispositivoRepository;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Component
public class Simulador {
    @Autowired
    @Qualifier("dispositivoRepository")
    private IDispositivoRepository dispositivoRepository;
    @Autowired
    @Qualifier("dispositivoService")
    private IDispositivoService dispositivoService;
    
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    
    @Scheduled(fixedDelay = 10000)  
    public void runJob() {
        // obtengo lista de camaras creadas del momento
        int aleatorio = (int) (Math.random() * dispositivoRepository.getAllDispositivoYAtributos().size());

        if (!dispositivoRepository.getAllDispositivoYAtributos().isEmpty()) {
            Dispositivo dispositivo = dispositivoRepository.getAllDispositivoYAtributos().get(aleatorio);
            try {
                // accedo a un dispositivo ya creada aleatoria y activo la funcion simulando que detecto algo
                dispositivoService.simular(dispositivo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}