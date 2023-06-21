package com.unla.grupo13OO22023.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Scheduled(fixedDelay=5000)
	public void runJob() {
//		System.out.println("prueba");
	}
}
