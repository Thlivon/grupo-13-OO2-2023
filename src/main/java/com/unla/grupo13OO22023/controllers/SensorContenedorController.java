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
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IDispositivoService;

@Controller
@RequestMapping("/sensorContenedor")
public class SensorContenedorController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.SENSORCONTENEDOR_LISTA);
		mAV.addObject("sensoresContenedor", dispositivoService.getAllSensoresContenedor());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView newSensorContenedor() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORCONTENEDOR_NEW);
		mAV.addObject("sensorContenedor", new SensorContenedor());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView crear(@ModelAttribute("sensorContenedor") SensorContenedor sensorContenedor) {
		dispositivoService.insertOrUpdate(modelMapper.map(sensorContenedor, SensorContenedor.class));
		return new RedirectView(ViewRouteHelper.SENSORCONTENEDOR_CREAR);
	}
}
