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

import com.unla.grupo13OO22023.entities.Habilitacion;
import com.unla.grupo13OO22023.helpers.ViewRouteHelper;
import com.unla.grupo13OO22023.services.IDispositivoService;
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

	@GetMapping("")
	public ModelAndView lista() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_LISTA);
		mAV.addObject("dispositivos", dispositivoService.getAll());
		mAV.addObject("habilitacionCamara", habilitacionService.findByNombre("Habilitacion Camaras"));
		mAV.addObject("habilitacionContenedor", habilitacionService.findByNombre("Habilitacion Sensores Contenedor"));
		mAV.addObject("habilitacionHumedad", habilitacionService.findByNombre("Habilitacion Sensores Humedad"));
		return mAV;
	}
	// IMPLEMENTAR EL CREAR

	// vista de 1 dispositivo
	@GetMapping("/{idDispositivo}")
	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_UPDATE);
		mAV.addObject("dispositivo", dispositivoService.findByIdDispositivo(idDispositivo));
		return mAV;
	}

//	@PostMapping("/update")
//	public RedirectView update(@ModelAttribute("dispositivo") Dispositivo dispositivo) {
//		dispositivoService.insertOrUpdate(dispositivo);
//		return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
//	}
	// CAMBIA A HABILITADO O DESHABILITADO UN >>>TIPO<<< DE DISPOSITIVO
	@PostMapping("/cambiarhabilitacion/{idHabilitacion}")
	public RedirectView cambiarHabilitacion(@PathVariable("idHabilitacion") int idHabilitacion) {
		boolean aux = habilitacionService.findByIdHabilitacion(idHabilitacion).isHabilitado();// AGARRO EL BOOLEAN PARA
																								// SABER SI ESTÁ O NO
																								// HABILITADO EL TIPO
		if (aux) {
			dispositivoService.cambiarActivadoSegunHabilitado(idHabilitacion); // ACA CAMBIAN A FALSE SI EL TIPO ESTABA
																				// HABILITADO Y VA A DESHABILITARSE
		}
		habilitacionService.cambiarHabilitacion(idHabilitacion, !aux);// ACA CAMBIA EL BOOLEAN DE TIPO DE DISPOSITIVO
		return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
	}

	// CAMBIA DE PRENDIDO O APAGADO A UN DISPOSITIVO ESPECÍFICO
	@PostMapping("/cambiaractivado/{idDispositivo}")
	public RedirectView cambiarActivado(@PathVariable("idDispositivo") int idDispositivo, RedirectAttributes redirectAttributes, Model model) {
		boolean habilitacion = dispositivoService.findByIdDispositivo(idDispositivo).getHabilitado().isHabilitado();
		if (habilitacion) {
			boolean aux = dispositivoService.findByIdDispositivo(idDispositivo).isActivado();
			dispositivoService.cambiarActivado(idDispositivo, !aux);
			return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
		} else {
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
		dispositivoService.remove(idDispositivo);
		return new RedirectView(ViewRouteHelper.DISPOSITIVO_ROOT);
	}

}
