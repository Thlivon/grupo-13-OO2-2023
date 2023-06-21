package com.unla.grupo13OO22023.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.entities.Evento;
import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.entities.SensorContenedor;
import com.unla.grupo13OO22023.entities.SensorHumedad;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IDispositivoService;
import com.unla.grupo13OO22023.services.IEventoService;
import com.unla.grupo13OO22023.services.IHabilitacionService;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	@Autowired
	@Qualifier("habilitacionService")
	private IHabilitacionService habilitacionService;
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_LISTA);
		mAV.addObject("dispositivos", dispositivoService.getAll());
		mAV.addObject("habilitacionCamara", habilitacionService.findByNombre("Habilitacion Camaras"));
		mAV.addObject("habilitacionContenedor", habilitacionService.findByNombre("Habilitacion Sensores Contenedor"));
		mAV.addObject("habilitacionHumedad", habilitacionService.findByNombre("Habilitacion Sensores Humedad"));
		return mAV;
	}
	
	// CAMBIA A HABILITADO O DESHABILITADO UN >>>TIPO<<< DE DISPOSITIVO
	@PostMapping("/cambiarhabilitacion/{idHabilitacion}")
	public RedirectView cambiarHabilitacion(@PathVariable("idHabilitacion") int idHabilitacion) {
		boolean aux = habilitacionService.findByIdHabilitacion(idHabilitacion).isHabilitado();// AGARRO EL BOOLEAN PARA
																								// SABER SI ESTÁ O NO
																								// HABILITADO EL TIPO
		if (aux) {
			dispositivoService.cambiarActivadoSegunHabilitado(idHabilitacion); 	// CAMBIA A FALSE LOS DISPOSITIVOS
																				// SI EL TIPO ESTABA
																				// HABILITADO Y VA A DESHABILITARSE
		}
		habilitacionService.cambiarHabilitacion(idHabilitacion, !aux);	//CAMBIA EL BOOLEAN DE TIPO DE DISPOSITIVO
		return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
	}

	// CAMBIA DE PRENDIDO O APAGADO A UN DISPOSITIVO ESPECÍFICO
	@PostMapping("/cambiaractivado/{idDispositivo}")
	public RedirectView cambiarActivado(@PathVariable("idDispositivo") int idDispositivo, RedirectAttributes redirectAttributes, Model model) {
		boolean habilitacion = dispositivoService.findByIdDispositivo(idDispositivo).getHabilitado().isHabilitado();
		//busco al dispositivo en la bdd
		Dispositivo dispositivo = dispositivoService.findByIdDispositivo(idDispositivo);
		//creo el evento
		String evAux="Se activo";
		if(dispositivo.isActivado()) evAux = "Se desactivo";
		Evento evento = new Evento(evAux,dispositivo);
		//establezco la relacion
		dispositivo.getEventos().add(evento); 
		//lo cargo en la bdd
		eventoService.insertOrUpdate(evento); 
		
		
		
		if (habilitacion) {	//Si su tipo de dispositivo esta habilitado 
			boolean aux = dispositivoService.findByIdDispositivo(idDispositivo).isActivado();
			dispositivoService.cambiarActivado(idDispositivo, !aux);
			return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
		} else {	//Si el tipo no esta habilitado, entonces no puedo activar un dispositivo. 
			//Traigo la habilitacion que corresponde al dispositivo que falla
			Habilitacion h = dispositivoService.findByIdDispositivo(idDispositivo).getHabilitado();
			//Mensaje de error que se va a mostrar
			String errorMessage = "ERROR: No se puede activar el dispositivo porque "+ h.getNombre() + " no esta habilitada";
			redirectAttributes.addFlashAttribute("error", errorMessage);
			return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
		}
	}

	@PostMapping("/delete/{idDispositivo}")
	public RedirectView delete(@PathVariable("idDispositivo") int idDispositivo) {
		String aux="";
		if(dispositivoService.findByIdDispositivo(idDispositivo) instanceof CamaraAula)aux = ViewRouteHelper.CAMARA_ROOT;
		if(dispositivoService.findByIdDispositivo(idDispositivo) instanceof SensorContenedor)aux = ViewRouteHelper.SENSORCONTENEDOR_ROOT;
		if(dispositivoService.findByIdDispositivo(idDispositivo) instanceof SensorHumedad)aux = ViewRouteHelper.SENSORHUMEDAD_ROOT;
		dispositivoService.remove(idDispositivo);
		return new RedirectView(aux);
	}
	
	
	//EVENTOS POR DISPOSITIVO
	@GetMapping("/{idDispositivo}")
    public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_LISTA);
        Dispositivo dispositivo = dispositivoService.findByIdDispositivo(idDispositivo);

        mAV.addObject("dispositivo", dispositivo);
        mAV.addObject("eventos", dispositivo.getEventos());
        return mAV;
    }
	

}
