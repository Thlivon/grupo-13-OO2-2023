package com.unla.grupo13OO22023.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo13OO22023.entities.EspacioVerde;
import com.unla.grupo13OO22023.entities.SensorHumedad;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IEspacioVerdeService;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Controller
@RequestMapping("/sensorhumedad")
public class SensorHumedadController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@Autowired
	@Qualifier("espacioVerdeService")
	private IEspacioVerdeService espacioVerdeService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.SENSORHUMEDAD_LISTA); 
		mAV.addObject("sensoresHumedad", dispositivoService.getAllSensoresHumedad());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView newSensorHumedad() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORHUMEDAD_NEW);
		mAV.addObject("sensorHumedad", new SensorHumedad());
		mAV.addObject("espaciosVerdes", espacioVerdeService.getAll());
		return mAV; //aca
	}
	
	@PostMapping("/create")
	public RedirectView crear(@ModelAttribute("sensorHumedad") SensorHumedad sensorHumedad, ModelMap model) {
		EspacioVerde espacioVerde = espacioVerdeService.findByIdEspacioVerde(sensorHumedad.getEspacioVerde().getIdEspacioVerde());
		espacioVerde.setSenHumedad(sensorHumedad);
	    dispositivoService.insertOrUpdate(sensorHumedad);
	    espacioVerdeService.insertOrUpdate(espacioVerde);
	    model.addAttribute("espacioVerdes", espacioVerdeService.getAll());
	    return new RedirectView(ViewRouteHelper.SENSORHUMEDAD_ROOT);
	}
	//pagina de actualizar y eliminar
	@GetMapping("/{idDispositivo}")
	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORHUMEDAD_UPDATE);
		mAV.addObject("sensorHumedad", dispositivoService.findByIdDispositivo(idDispositivo));
		return mAV;
	}
	//cuando apretas update
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("sensorHumedad") SensorHumedad sensorHumedad) {
		dispositivoService.insertOrUpdate(sensorHumedad);
		return new RedirectView(ViewRouteHelper.SENSORHUMEDAD_ROOT);
	}
	//cuando apretas delete
	@PostMapping("/delete/{idDispositivo}")
	public RedirectView delete(@PathVariable("idDispositivo") int idDispositivo) {
		SensorHumedad sensorHumedad= (SensorHumedad)dispositivoService.findByIdDispositivo(idDispositivo);
		sensorHumedad.getEspacioVerde().setSenHumedad(null);
		dispositivoService.remove(idDispositivo);
		return new RedirectView(ViewRouteHelper.SENSORHUMEDAD_ROOT);
	}
}

