package com.unla.grupo13OO22023.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IAulaService;
import com.unla.grupo13OO22023.services.IDispositivoService;


@Controller
@RequestMapping("/camara")
public class CamaraController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.CAMARA_LISTA);
		mAV.addObject("camaras", dispositivoService.getAllCamaras());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView newCamara() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAMARA_NEW);
		mAV.addObject("camara", new CamaraAula());
        mAV.addObject("aulas", aulaService.getAll());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView crear(@ModelAttribute("camara") CamaraAula camara) {
	
//		switch()
//		case 1: camara.setAula(lstAulas.get(0));
//		
		dispositivoService.insertOrUpdate(camara);
		return new RedirectView(ViewRouteHelper.CAMARA_ROOT);
	}
	
	
	@GetMapping("/{idDispositivo}")
	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAMARA_UPDATE);
		mAV.addObject("camara", dispositivoService.findByIdDispositivo(idDispositivo));
		return mAV;
	}
	
	@PostMapping("/update")
    public RedirectView update(@ModelAttribute("camara") CamaraAula camara) {
        dispositivoService.insertOrUpdate(camara);
        return new RedirectView(ViewRouteHelper.CAMARA_ROOT);
    }
	
	@PostMapping("/delete/{idDispositivo}")
	public RedirectView delete(@PathVariable("idDispositivo") int idDispositivo) {
		dispositivoService.remove(idDispositivo);
		return new RedirectView(ViewRouteHelper.CAMARA_ROOT);
	}
	

}
