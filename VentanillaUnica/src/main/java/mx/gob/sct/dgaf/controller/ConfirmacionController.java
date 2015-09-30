package mx.gob.sct.dgaf.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.gob.sct.dgaf.model.TPersona;
import mx.gob.sct.dgaf.services.IAdminPersonasService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfirmacionController {
	
	private static final Logger LOGVU = LoggerFactory.getLogger(ConfirmacionController.class);
	HttpSession session = null;
	
	@Autowired
	private IAdminPersonasService adminPersonasService;
	
	@RequestMapping(value = "/confirmMailUser/{userconfirm}.sct")
	public ModelAndView cargaPaginaTramites(@PathVariable String userconfirm,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		final ModelAndView modela = new ModelAndView("login");
		modela.addObject("userconfirm", true);
		modela.addObject("ConfirmaRFC", userconfirm.toString());
		
		return modela;
	}
	
	@RequestMapping(value = "/goToTramites.sct")
	public void cargaPaginaTramites(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		LOGVU.info("Carga Pagina para crear solicitudes");
		response.getOutputStream().println("../solicitudes/tramites.jsp");
		
		LOGVU.debug(" *** Despues de cargar pagina ");
		
	}
	
	@RequestMapping(value = "/confirmar.sct")
	public void LoadConfirmar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		try{
			
			LOGVU.info("Carga Pagina confirmacion");
			response.getOutputStream().println("../confirmacion/confirmacion.jsp");
			
		}catch(Exception e){
			LOGVU.info("Error al cargar la pagina de confirmacion");
		}
		
		/*
		HashMap<String, String> hashMapParameter = new HashMap<String, String>();
		String RfcPersona = null;

		LOGVU.info("Carga Confirmacion");
		try {
			session = request.getSession(false);
			if(session!=null){
				
				RfcPersona = (String) session.getAttribute("ConfirmaRFC");
				LOGVU.info("RFC-Persona: "+RfcPersona);
			}else{
				LOGVU.info("La SESSION no Existe");
			}
		}catch(Exception e){
			LOGVU.info("Error en Confirmacion: "+e);
		}
		
		//obtener la fecha del registro por RFC de la persona
		hashMapParameter.put("rfc", RfcPersona);
		TPersona persona= adminPersonasService.getConfirmDatesByRFC(hashMapParameter);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String FRegistro = df.format(persona.getFechaActualiza());
		String FHoy = df.format(persona.getFechaRegistro());
		//LOGVU.debug("** Value Of FECHAACTUALIZA: "+FRegistro+" FECHAREGISTRO: "+FHoy);
		

		if( validate(FHoy, FRegistro) ){
			//LOGVU.debug(" -------llama el update de confirmacion");
			int result = adminPersonasService.updateEstatusByRFC(rfc);
		}else{
			LOGVU.debug(" -------Manda mensage: SU SOLICITUD HA EXPIRADO");
			//myResponse.sendRedirect("confirmacionErr.jsp");
		}*/
	}
	
	private boolean validate( String fecHoy, String fecTramite ){
		//LOGVU.debug(" -----Entra a validate");
		boolean SolicActual = false;
		
		String[] fechaNow = fecHoy.split("-");
		int yearNow = Integer.parseInt(fechaNow[0]);
		int monthNow = Integer.parseInt(fechaNow[1]);
		int dayNow = Integer.parseInt(fechaNow[2]);
		
		String[] fechaIni = fecTramite.split("-");
		int year = Integer.parseInt(fechaIni[0]);
		int month = Integer.parseInt(fechaIni[1]);
		int day = Integer.parseInt(fechaIni[2]);
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal1.set(year, month, day);
		cal2.set(yearNow, monthNow, dayNow);
		
		// conseguir la representacion de la fecha en milisegundos
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();

		// calcular la diferencia en milisengundos
		long diff = milis1 - milis2;

		long diffDays = diff / (24 * 60 * 60 * 1000);
		//LOGVU.debug(" *** diferencia: "+diffDays);
		
		if( diffDays < 6 ){
			SolicActual = true;
		}else{
			SolicActual = false;
		}
		
		
		return SolicActual;
	}
	

}
