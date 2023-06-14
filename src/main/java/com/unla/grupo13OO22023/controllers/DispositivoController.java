package com.unla.grupo13OO22023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {

	@GetMapping("lista")
	public String listaDisposotivos() {
		return "ListaDispositivos";
	}
	
	@GetMapping("/agregardispositivo")
    public String agregarDispositvo(/*Model model*/) {
        //Employee employee = new Employee(); //implementacion logica luego
        //model.addAttribute("employee", employee);
        return "AgregarDispositivo";
    }
	
}
