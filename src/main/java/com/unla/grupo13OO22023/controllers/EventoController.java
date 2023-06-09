package com.unla.grupo13OO22023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.repositories.IEventoRepository;
import com.unla.grupo13OO22023.services.IEventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    @Qualifier("eventoService")
    private IEventoService eventoService;
    
    @GetMapping("")
    public ModelAndView lista() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_LISTA);
        mAV.addObject("eventos", eventoService.getAll());
        return mAV;
    }
    
    //EVENTOS POR TIPO DE DISPOSITIVO
  	@GetMapping("/{idHabilitacion}")
  	public ModelAndView get(@PathVariable("idHabilitacion") int idHabilitacion) {
  		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_LISTA);
  				
  		mAV.addObject("eventos", eventoService.getAllEventosPorTipo(idHabilitacion));
  		return mAV;
  	}
    
  	//findFirst10ByOrderByFechaEventoDesc
  	@GetMapping("/ultimos10")
  	public ModelAndView getUltimosEventos() {
  	    ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_LISTA);
  	            
  	    List<Evento> ultimosEventos = eventoService.findFirst10ByOrderByFechaYHoraDesc();
  	    mAV.addObject("eventos", ultimosEventos);
  	    
  	    return mAV;
  	}

}
