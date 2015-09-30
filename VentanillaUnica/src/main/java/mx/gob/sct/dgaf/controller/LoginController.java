package mx.gob.sct.dgaf.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.gob.sct.dgaf.model.TPersona;
import mx.gob.sct.dgaf.services.IAdminPersonasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.itextpdf.text.DocumentException;


@Controller
public class LoginController {

	private static final Logger LOGVU = LoggerFactory.getLogger(LoginController.class);
	HttpSession session=null;
	String rfc=null;
	String curp=null;
	
	@Autowired
	protected MessageSource messageSource;
	@Autowired
	private IAdminPersonasService adminPersonasService;
	
	
	
	@RequestMapping(value = "/login.sct")
	public String cargaPag(HttpServletRequest request,HttpServletResponse response) throws IOException, DocumentException{
		HashMap<String, String> hashMapParameter =null;
		TPersona persona=null;
		
		LOGVU.info("Inicia carga de pagina HOME");
		try {
			session=null;
			hashMapParameter = new HashMap<String, String>();
			session = request.getSession(true);
			rfc=request.getParameter("rfc");
			curp=request.getParameter("curp");
			String  confirm= request.getParameter("confirm");
			String ConfirmaRFC = request.getParameter("rfcConfirm");
			
			if(rfc==null||curp==null){
				LOGVU.info("No existen datos proporcioandos por el APPLET del SAT");
				return "redirect:/";
			}else{
				LOGVU.info(new StringBuilder("Datos obtenidos por el APPLET rfc:")
				.append(rfc).append(" curp:").append(curp)
				.append(" confirm:").append(confirm)
				.append(" rfcConfirm:").append(ConfirmaRFC).toString());
				
				hashMapParameter.put("rfc", rfc);
				hashMapParameter.put("curp", curp);
				persona= adminPersonasService.getPersonaPorRC(hashMapParameter);
				
				if( confirm.equals("true") ){ //huribe
					LOGVU.info("Existe persona para confirmar: "+ persona);
					session.setAttribute("TPersona", persona);					
					session.setAttribute("ExisteTPersona", true);
					session.setAttribute("ConfirmaRFC", ConfirmaRFC);
					return "redirect:/home/confirm_sct.jsp";
				}else{
					if(persona!=null){
						LOGVU.info("Existe persona: "+ persona);
						session.setAttribute("TPersona", persona);					
						session.setAttribute("ExisteTPersona", true);
						return "redirect:/home/home_sct.jsp";
					}else{
						LOGVU.info("No existe persona");
						session.setAttribute("ExisteTPersona", false);
						return "redirect:/home/home_sct.jsp";
					}
				}
			}
		    
		} catch (Exception e) {
			session=null;
			e.printStackTrace();
			return "redirect:/";
		}	
	}

}
