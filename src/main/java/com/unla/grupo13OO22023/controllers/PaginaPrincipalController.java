package com.unla.grupo13OO22023.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo13OO22023.helpers.ViewRouteHelper;

@Controller
@RequestMapping("")

public class PaginaPrincipalController {

	//Cuando abris el localhost aparezcas en el inicio
	@GetMapping("")
	public String inicio() {
		return ViewRouteHelper.ESTRUCTURA_INICIO;
	}

	//Para poder volver atras desde la navbar
	@GetMapping("/inicio")
	public String inicio2() {
		return ViewRouteHelper.ESTRUCTURA_INICIO;
	}
	
}
