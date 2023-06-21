package com.unla.grupo13OO22023.controllers;

import java.util.HashSet;
import java.util.Set;

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

import com.unla.grupo13OO22023.entities.Aula;
import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Contenedor;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IAulaService;
import com.unla.grupo13OO22023.services.IContenedorService;
import com.unla.grupo13OO22023.services.IDispositivoService;
import com.unla.grupo13OO22023.services.IEventoService;
import com.unla.grupo13OO22023.services.IHabilitacionService;

@Controller
@RequestMapping("/sensorcontenedor")
public class SensorContenedorController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@Autowired
	@Qualifier("contenedorService")
	private IContenedorService contenedorService;
	
	@Autowired
	@Qualifier("habilitacionService")
	private IHabilitacionService habilitacionService;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.SENSORCONTENEDOR_LISTA); 
		mAV.addObject("habilitacion", habilitacionService.findByNombre("Habilitacion Sensores Contenedor"));
		mAV.addObject("sensoresContenedor", dispositivoService.getAllSensoresContenedor());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView newSensorContenedor() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORCONTENEDOR_NEW);
		mAV.addObject("sensorContenedor", new SensorContenedor());
		mAV.addObject("contenedores", contenedorService.getAll());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView crear(@ModelAttribute("sensorContenedor") SensorContenedor sensorContenedor, ModelMap model) {
		//Creo un evento e inicializo la lista
		Evento evento = new Evento("Creacion");
		Set<Evento> listaEventos = new HashSet<>();;
		sensorContenedor.setEventos(listaEventos);
		
		//busco en la bdd
		Contenedor contenedor = contenedorService.findByIdContenedor(sensorContenedor.getContenedor().getIdContenedor());
		Habilitacion habilitacion = habilitacionService.findByNombre("Habilitacion Sensores Contenedor");
		
	    //setteo las relaciones
		contenedor.setSensor(sensorContenedor);
		habilitacion.getDispositivos().add(sensorContenedor);
		sensorContenedor.setHabilitado(habilitacion);
	    evento.setDispositivo(sensorContenedor);//new
	    sensorContenedor.getEventos().add(evento);//new
	    
	    //guardo en la bd
	    dispositivoService.insertOrUpdate(sensorContenedor);
	    contenedorService.insertOrUpdate(contenedor);
	    eventoService.insertOrUpdate(evento);//new
	    	    
	    model.addAttribute("contenedores", contenedorService.getAll());
	    return new RedirectView(ViewRouteHelper.SENSORCONTENEDOR_ROOT);
	}
//	//pagina de actualizar y eliminar
//	@GetMapping("/{idDispositivo}")
//	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_UPDATE);
//		mAV.addObject("sensorContenedor", dispositivoService.findByIdDispositivo(idDispositivo));
//		return mAV;
//	}
//	//cuando apretas update
//	@PostMapping("/update")
//	public RedirectView update(@ModelAttribute("sensorContenedor") SensorContenedor sensorContenedor) {
//		dispositivoService.insertOrUpdate(sensorContenedor);
//		return new RedirectView(ViewRouteHelper.SENSORCONTENEDOR_ROOT);
//	}
//	//cuando apretas delete
//	@PostMapping("/delete/{idDispositivo}")
//	public RedirectView delete(@PathVariable("idDispositivo") int idDispositivo) {
//		SensorContenedor sensorContenedor= (SensorContenedor)dispositivoService.findByIdDispositivo(idDispositivo);
//		sensorContenedor.getContenedor().setSensor(null);
//		dispositivoService.remove(idDispositivo);
//		return new RedirectView(ViewRouteHelper.SENSORCONTENEDOR_ROOT);
//	}
}