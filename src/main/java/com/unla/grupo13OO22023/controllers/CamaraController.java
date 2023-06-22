package com.unla.grupo13OO22023.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IAulaService;
import com.unla.grupo13OO22023.services.IDispositivoService;
import com.unla.grupo13OO22023.services.IEventoService;
import com.unla.grupo13OO22023.services.IHabilitacionService;
import org.springframework.security.core.userdetails.User;

@Controller
@RequestMapping("/camara")
public class CamaraController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;

	@Autowired
	@Qualifier("habilitacionService")
	private IHabilitacionService habilitacionService;
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

//	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("")
		public ModelAndView lista() {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAMARA_LISTA);
			mAV.addObject("habilitacion", habilitacionService.findByNombre("Camaras"));
			mAV.addObject("camaras", dispositivoService.getAllCamaras());
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			mAV.addObject("rol", user.getUsername());
			return mAV;
		}

	// 1 aula no puede tener mas de 1 dispositivo
	@GetMapping("/new")
	public ModelAndView newCamara() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAMARA_NEW);
		mAV.addObject("camara", new CamaraAula());
		mAV.addObject("aulas", aulaService.getAll());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView crear(@ModelAttribute("camara") CamaraAula camara, ModelMap model) {
		// Creo un evento e inicializo la lista
		Evento evento = new Evento("Creacion");
		Set<Evento> listaEventos = new HashSet<>();
		camara.setEventos(listaEventos);

		// busco en la bdd
		Aula aula = aulaService.findByIdAula(camara.getAula().getIdAula());
		Habilitacion habilitacion = habilitacionService.findByNombre("Camaras");

		// setteo las relaciones
		aula.setCamara(camara);
		habilitacion.getDispositivos().add(camara);
		camara.setHabilitado(habilitacion);
		evento.setDispositivo(camara);// new
		camara.getEventos().add(evento);// new

		// guardo en la bd
		dispositivoService.insertOrUpdate(camara);
		aulaService.insertOrUpdate(aula);
		eventoService.insertOrUpdate(evento);// new

		model.addAttribute("aulas", aulaService.getAll());
		return new RedirectView(ViewRouteHelper.CAMARA_ROOT);
	}

//	//vista de 1 dispositivo
//	@GetMapping("/{idDispositivo}")
//	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_UPDATE);
//		mAV.addObject("camara", dispositivoService.findByIdDispositivo(idDispositivo));
//		return mAV;
//	}
//
//	@PostMapping("/update")
//	public RedirectView update(@ModelAttribute("camara") CamaraAula camara) {
//		dispositivoService.insertOrUpdate(camara);
//		return new RedirectView(ViewRouteHelper.CAMARA_ROOT);
//	}
//
//	@PostMapping("/delete/{idDispositivo}")
//	public RedirectView delete(@PathVariable("idDispositivo") int idDispositivo) {
//		dispositivoService.remove(idDispositivo);
//		return new RedirectView(ViewRouteHelper.CAMARA_ROOT);
//	}

}