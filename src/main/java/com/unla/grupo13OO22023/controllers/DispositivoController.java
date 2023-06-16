package com.unla.grupo13OO22023.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.models.DispositivoModel;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("lista")
	public String listaDisposotivos() {
		return "ListaDispositivos";
	}
	//-----------------------------
	//Falta implementarlo en el html
	@GetMapping("/")
	public ModelAndView lista() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.DISPOSITIVO_LISTA);
		mAV.addObject("dispositivos", dispositivoService.getAll());
		return mAV;
	}
	
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute("dispositivo") DispositivoModel dispositivoModel) {
		dispositivoService.insertOrUpdate(modelMapper.map(dispositivoModel, Dispositivo.class));
		return new RedirectView(ViewRouteHelper.DISPOSITIVO_CREAR);
	}
	//----------------------------
	@GetMapping("/agregardispositivo")
    public String agregarDispositvo(/*Model model*/) {
        //Employee employee = new Employee(); //implementacion logica luego
        //model.addAttribute("employee", employee);
        return "AgregarDispositivo";
    }
	
}
