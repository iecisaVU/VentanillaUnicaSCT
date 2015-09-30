package mx.gob.sct.dgaf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.TPersona;
import mx.gob.sct.dgaf.model.TSolPersona;
import mx.gob.sct.dgaf.model.VUDeptoTramite;
import mx.gob.sct.dgaf.model.VUDetalleSol;
import mx.gob.sct.dgaf.model.VUSolicitud;
import mx.gob.sct.dgaf.services.ITramXLSService;
import mx.gob.sct.dgaf.services.ITramiteService;
import mx.gob.sct.dgaf.util.VUTramConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class SolicitudController {
	
	private static final Logger LOGVU = LoggerFactory.getLogger(SolicitudController.class);
	
	@Autowired
	private ITramiteService iTramiteServ;
	
	@Autowired
	private ITramXLSService iTramXLSServ;
	
	@RequestMapping(value="/viewTramAct.sct",method=RequestMethod.GET)
	public void cargaPag(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getOutputStream().println(
				new StringBuilder(request.getContextPath())
				.append("/solicitudes/tramites-act.jsp").toString());
	}
	
	@RequestMapping(value="/viewTramNuv.sct",method=RequestMethod.GET)
	public void cargaPagNuv(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getOutputStream().println(
				new StringBuilder(request.getContextPath())
				.append("/solicitudes/tramites-nue.jsp").toString());
	}
	
	@RequestMapping(value="/viewTramFin.sct",method=RequestMethod.GET)
	public void cargaPagFin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getOutputStream().println(
				new StringBuilder(request.getContextPath())
				.append("/solicitudes/tramites-fin.jsp").toString());
	}
	
	@RequestMapping(value="/viewTramNot.sct",method=RequestMethod.GET)
	public void cargaPagNot(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getOutputStream().println(
				new StringBuilder(request.getContextPath())
				.append("/solicitudes/tramites-not.jsp").toString());
	}
	
	@RequestMapping(value="/loadTramAct.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VUSolicitud> cargaTramAct(HttpServletRequest request)
			throws IOException {
		LOGVU.debug("-----------------------------------loadTramAct");
		try {
			final List<VUSolicitud> listSol = this.iTramiteServ.
					buscaSolicAct(this.getPersonaSess(request).getRfc()); 
			return listSol;
		} catch(final VUException vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return new ArrayList<VUSolicitud>();
	}
	
	@RequestMapping(value="/viewSelTramAct.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VUDetalleSol> viewSelTram(@RequestParam Long idSolSel) {
		LOGVU.debug("-----------------------------------viewSelTram");
		try {
			return this.iTramiteServ.buscaDetSolic(idSolSel);
		} catch(final VUException vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return new ArrayList<VUDetalleSol>();
	}
	
	@RequestMapping(value="/getListtram.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VUDeptoTramite> loadListTram() {
		LOGVU.debug("-----------------------------------loadListTram");
		try {
			return this.iTramiteServ.buscaTramActiv();
		} catch(final VUException vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return new ArrayList<VUDeptoTramite>();
	}
	
	@RequestMapping(value="/addTramSel.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addTram(@RequestParam Integer idTramNuv,
			HttpServletRequest request) {
		LOGVU.debug(
				new StringBuilder("-----------------------------addTram")
				.append(idTramNuv).toString());
		try {
			this.iTramiteServ.agregaNuevoTram(idTramNuv, this.getPersonaSess(request).getRfc());
		} catch (VUException vuexpo) {
			LOGVU.error("error al crear nueva solicitud", vuexpo);
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/loadTramFin.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VUSolicitud> cargaTramFin(HttpServletRequest request)
			throws IOException {
		LOGVU.debug("-----------------------------------cargaTramFin");
		try {
			final List<VUSolicitud> listSol = this.iTramiteServ.buscaSolicFin(this.getPersonaSess(request).getRfc()); 
			return listSol;
		} catch(final VUException vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return new ArrayList<VUSolicitud>();
	}
	
	@RequestMapping(value="/loadNotSol.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TSolPersona> cargaNotSol(HttpServletRequest request)
			throws IOException {
		LOGVU.debug("-----------------------------------cargaNotSol");
		try {
			return this.iTramiteServ.buscaNotSolic(this.getPersonaSess(request).getRfc());
		} catch(final VUException vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return new ArrayList<TSolPersona>();
	}
	
	@RequestMapping(value="/loadNotNum.sct",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loadNumNot(HttpServletRequest request)
			throws IOException {
		LOGVU.debug("-----------------------------------loadNumNot");
		try {
			return String.valueOf(this.iTramiteServ.buscaNumNot(this.getPersonaSess(request).getRfc()));
		} catch(final Exception vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return "";
	}
	
	@RequestMapping(value="/loadTramNom.sct",method=RequestMethod.GET)
	public @ResponseBody String loadNomCom(HttpServletRequest request)
			throws IOException {
		LOGVU.debug("-----------------------------------loadNumNot");
		try {
			final TPersona persona = this.getPersonaSess(request);
			final StringBuilder nomCom = new StringBuilder(persona.getNombre())
			.append(" ").append(persona.getApPaterno())
			.append(" ").append(persona.getApMaterno());
			
			return nomCom.toString();
		} catch(final Exception vuexpo) {
			LOGVU.error(vuexpo.getMessage());
		}
		return "";
	}

	@RequestMapping(value="/downRepFin.sct",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> descarRepFin(HttpServletRequest request, HttpServletResponse response) throws VUException, Exception {
		
		final String rfcuser = this.getPersonaSess(request).getRfc();
		try {
			byte[] pdfInBytes = this.iTramiteServ.reportSolicFin(rfcuser);
			this.descargaArchivo(pdfInBytes, rfcuser, 
					VUTramConstants.EXT_PDF, VUTramConstants.APP_PDF, response);
		} catch (VUException expo) {
			LOGVU.error("error descarga archivo pdf", expo);
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/downRepFinXLS.sct",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> descarRepFinXLS(HttpServletRequest request, HttpServletResponse response)  {
		final String rfcuser = this.getPersonaSess(request).getRfc();
		try {
			byte[] xlsxInBytes = this.iTramXLSServ.reportSolicFin(rfcuser);
			this.descargaArchivo(xlsxInBytes, rfcuser, 
					VUTramConstants.EXT_XLSX, VUTramConstants.APP_XLSX, response);
		} catch (VUException expo) {
			LOGVU.error("error descarga archivo xlsx", expo);
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	private void descargaArchivo(byte[] archivo, final String rfcuser, final String extension, 
			final String contentType, HttpServletResponse response) throws VUException {
		try {
			final StringBuilder cadena = new StringBuilder(VUTramConstants.REPF_PREN)
			.append(rfcuser).append(extension);
			final StringBuilder header = new StringBuilder(VUTramConstants.REPF_ATT)
			.append(VUTramConstants.COMILLAS)
			.append(cadena.toString())
			.append(VUTramConstants.COMILLAS);
			
			response.setContentType(contentType);
	        response.setContentLength(archivo.length);
			response.setHeader(VUTramConstants.REPF_CONT, header.toString());
		
			FileCopyUtils.copy(archivo, response.getOutputStream());
			
		} catch (IOException expo) {
			LOGVU.error("error descarga archivo", expo);
		}
	}
	
//	iTramXLSServ
	
	private TPersona getPersonaSess(final HttpServletRequest request) {
		return (TPersona)request.getSession(false).getAttribute(VUTramConstants.LABE_PERSONA);
	}
}
