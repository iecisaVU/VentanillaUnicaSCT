package mx.gob.sct.dgaf.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.TCatTipoPersona;
import mx.gob.sct.dgaf.model.TPerDatosPersona;
import mx.gob.sct.dgaf.model.VUParametrosGenerales;
import mx.gob.sct.dgaf.model.TPersona;
import mx.gob.sct.dgaf.services.IAdminPersonasService;
import mx.gob.sct.dgaf.services.IParametrosGeneralesService;
import mx.gob.sct.dgaf.services.IPersonaMedPrevenService;
import mx.gob.sct.dgaf.util.GenerarPdf;
import mx.gob.sct.dgaf.util.VUTramConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/adminPersonas")
public class AdminPersonasController {
	@Autowired
	protected MessageSource messageSource;
	@Autowired
	private IParametrosGeneralesService parametrosGeneralesService;
	@Autowired
	private IAdminPersonasService adminPersonasService;
	@Autowired
	private GenerarPdf generarPdf;
	@Autowired
	private IPersonaMedPrevenService personaMedPrevenService;

	private static final Logger LOGVU = LoggerFactory.getLogger(AdminPersonasController.class);

	@RequestMapping(value="/verPersonasAdmin.sct",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TPersona> listPersonasAdmin(){
		List<TPersona> listPersonasAdm = adminPersonasService.getPersonasByPersonaAsociada(2L);
		LOGVU.info("");
		return listPersonasAdm;
	}
	
	@RequestMapping(value="/buscaPersonasCurp.sct",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TPerDatosPersona buscaPersonasCurp(@RequestParam String curp){
		TPerDatosPersona persona = personaMedPrevenService.buscaPersonaPorCurp(curp);
		LOGVU.info("buscaPersonasCurp con curo "+curp);
		return persona;
	}
	

	@RequestMapping(value="/getPersonasAdmin.sct",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TPersona getPersonasAdmin(){		
		LOGVU.info("");
		return adminPersonasService.getPersonaById(1L);
	}

	@RequestMapping(value="/agregarPersonaAdmin.sct",method=RequestMethod.POST,
			consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Boolean> agregarPersonaAdmin(@RequestBody List<TPersona> reportePost) {
		LOGVU.info("");
		HttpHeaders headers = new HttpHeaders();
		try {
			HashMap<String, TPersona> response = adminPersonasService.savePersonas(reportePost);
			for(Entry<String, TPersona> res: response.entrySet()){
				headers.set("SCTResponse", res.getKey());
			}
			return new ResponseEntity<Boolean>(true, headers,  HttpStatus.OK);
		} catch (VUException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, headers,  HttpStatus.PARTIAL_CONTENT);
		}
	}

	@RequestMapping(value="/editarPersonaAdmin.sct",method=RequestMethod.POST,
			consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TPersona> editarPersonaAdmin(@RequestBody List<TPersona> reportePost) {
		LOGVU.info("");
		return reportePost;
	}


	@RequestMapping(value="/parametroNotificaciones.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody VUParametrosGenerales parametroNotificaciones() throws VUException {
		LOGVU.info("AdminPersonasController ---->> Entras a obtener el parametro de numero maximo de notificaciones activas");
		return parametrosGeneralesService.getParametrsByClave("maxNotificaciones");
	}
	@RequestMapping(value="/parametroApoderado.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody VUParametrosGenerales parametroApoderado() throws VUException {
		LOGVU.info("AdminPersonasController ---->> Entras a obtener el parametro de numero maximo de Apoderado activo");
		return parametrosGeneralesService.getParametrsByClave("maxApoderado");
	}

	@RequestMapping(value="/catTipoPersona.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TCatTipoPersona> catTipoPersona() throws VUException {
		LOGVU.info("AdminPersonasController ---->> Entras a obtener tipos de persona");
		return adminPersonasService.listTipoPersona();
	}


	@RequestMapping(value="/acuseActividad.sct",method=RequestMethod.POST)			
	public  ResponseEntity<byte[]> acuseActividad(@RequestBody List<TPersona> reportePost) throws VUException {
		LOGVU.info("AdminPersonasController ---->> Entras a acuseActividad");
		String rutaPDF = messageSource.getMessage("generaPdf.pdf.rutaPdf", null,
				Locale.getDefault());
		ResponseEntity<byte[]> response = null;
		SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat hourFormat =  new SimpleDateFormat("h:mm a");

		List<String>lstHeaders =  new ArrayList<String>();
		lstHeaders.add("Acuse por movimiento en la administración de usuarios");
		//		lstHeaders.add("Dirección General de Autotransportes Federal");
		Map<String, String>mapCuerpo =  new LinkedHashMap<String, String>();
		mapCuerpo.put("Estatus", "OK");
		mapCuerpo.put("Razón Social", "Oscar MArtínez Rosales");
		mapCuerpo.put("RFC", "MARO830417374");
		mapCuerpo.put("Fecha",dateFormat.format(new Date()));
		mapCuerpo.put("Hora", hourFormat.format(new Date()));
		StringBuffer buffer = new StringBuffer();
		buffer.append("Alta de usuario(s) ");
		buffer.append("\n");
		for (TPersona persona : reportePost) {
			buffer.append(persona.getNombre());
			buffer.append(" ");
			buffer.append(persona.getIdTipoPersona()==1?" Como Notificaciones ":" Como Apoderado Legal ");
			buffer.append(persona.isActivo()?" Activo":" InActivo");
			buffer.append("\n");
		}
		mapCuerpo.put("Movimiento", buffer.toString());
		try {
			//generaPdf.pdf(nombrePdf,listaHeaderTable,mapa,firmaDigital)
			String fileName = "AdministracioUsuariosTodos.pdf";
			generarPdf.pdf(lstHeaders, mapCuerpo, "firma digital ???????????????????");

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = pdfBytes(rutaPDF+"\\"+fileName);			
			byte[] contents = baos.toByteArray();
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    
		    headers.setContentDispositionFormData(fileName, fileName);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    headers.set("SCTResponse", fileName);
		    response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		    return response;
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	private ByteArrayOutputStream pdfBytes(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}
	@RequestMapping(value="/personaSession.sct",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TPersona personaSession(HttpServletRequest request){

		return getPersonaSess(request);
	}
	
	private TPersona getPersonaSess(final HttpServletRequest request) {
		return (TPersona)request.getSession(false).getAttribute(VUTramConstants.LABE_PERSONA);
	}
}
