package mx.gob.sct.dgaf.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger LOGVU = LoggerFactory.getLogger(HomeController.class);
	HttpSession session = null;

	@RequestMapping("/ventanillaU.sct")
	public ModelAndView goHome(final HttpServletRequest request)
			throws ServletException, IOException {
		LOGVU.debug("/ventanillaU.sct");
		final ModelAndView modela = new ModelAndView("login");
		modela.addObject("userconfirm", false);
	
		return modela;
	}

	@RequestMapping(value = "/home.sct")
	public void cargaPaginaHome(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LOGVU.info("Carga Pagina");
		try {
			session = request.getSession(false);
			if(session!=null){
				if ((Boolean) session.getAttribute("ExisteTPersona")) {
					LOGVU.info("Carga Pagina para crear solicitudes");
					response.getOutputStream().println("../solicitudes/tramites.jsp");
				} else {
					LOGVU.info("Carga Pagina para crear persona");
					response.getOutputStream().println("../prueba/prueba.jsp");// va  pag de genera personas
				}
			}else{
				response.getOutputStream().println("../home/error.jsp");
			}
		} catch (Exception e) {
			response.getOutputStream().println("../home/error.jsp");
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/admonUsuarios.sct")
	public void admonUsuariosHome(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LOGVU.info("Carga Pagina admonUsuarios");
		try {
			session = request.getSession(false);
			if (session != null) {
				response.getOutputStream().println("../adminPersonas/adminPersonas.jsp");
			} else {
				if (session == null) {
					response.getOutputStream().println("../home/error.jsp");
				}
			}
		} catch (Exception e) {
			response.getOutputStream().println("../home/error.jsp");
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/cerrarSession.sct")
	public void cerrarSession(HttpServletRequest request,HttpServletResponse response) throws IOException {
		LOGVU.info("entra a cerrar Sesion");
		try {
			session = request.getSession(false);
			if(session!=null){
				
				final Enumeration<?> numeration = session.getAttributeNames(); 
					while (numeration.hasMoreElements()) { 
						session.removeAttribute((String) numeration.nextElement()); 
					}	 
				  
				session.invalidate();			
				response.getOutputStream().println("success"); 
				LOGVU.info("Conexion cerrada");
			}else{
				response.getOutputStream().println("error");
			}
			
		} catch (Exception e) {
			response.getOutputStream().println("error");
			e.printStackTrace();
		}
	}
}
