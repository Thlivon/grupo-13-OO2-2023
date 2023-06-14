package com.unla.grupo13OO22023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejemplo1")
public class EjemploThymeleafController {
	
	@GetMapping("thymeleaft")
	public String thymeleaft() {
		return "Thymeleaft";
	}

}
