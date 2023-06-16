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

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.models.CamaraModel;
import com.unla.grupo13OO22023.services.ICamaraService;


@Controller
@RequestMapping("/camara")
public class CamaraController {
	@Autowired
	@Qualifier("dispositivoService")
	private ICamaraService camaraService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.CAMARA_LISTA);
		mAV.addObject("camaras", camaraService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView newCamara() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAMARA_NEW);
		mAV.addObject("camara", new CamaraAula());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView crear(@ModelAttribute("camara") CamaraModel camaraModel) {
		camaraService.insertOrUpdate(modelMapper.map(camaraModel, CamaraAula.class));
		return new RedirectView(ViewRouteHelper.CAMARA_CREAR);
	}
}
