package mx.gob.sct.dgaf.services.impl;

import java.util.Calendar;
import java.util.List;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.TSolPersona;
import mx.gob.sct.dgaf.model.VUDeptoTramite;
import mx.gob.sct.dgaf.model.VUDetalleSol;
import mx.gob.sct.dgaf.model.VUSolicitud;
import mx.gob.sct.dgaf.services.ITramiteService;
import mx.gob.sct.dgaf.services.dao.ITramiteDao;
import mx.gob.sct.dgaf.util.GenerarPdf;
import mx.gob.sct.dgaf.util.VUFechasUtil;
import mx.gob.sct.dgaf.util.VUTramConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("iTramiteServ")
public class TramiteServiceImpl implements ITramiteService {
	
	private static final Logger LOGVU = LoggerFactory.getLogger(TramiteServiceImpl.class);
	
	@Autowired
	private ITramiteDao iTramDao;
	
	@Autowired
	protected MessageSource messageSource;
	
	@Autowired
	private GenerarPdf generaPdf;

	@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public String agregaNuevoTram(final Integer idTram, final String rfcUser) throws VUException {
		LOGVU.debug("agregaNuevoTram");
		//se espera que los valores del usuario esten en sesion
		//TODO:iarcos como se define el folio para la solicitud
		final VUSolicitud solicit = new VUSolicitud();
		solicit.setConsecutivo(0);
		solicit.setFechaReg(Calendar.getInstance().getTime());
		solicit.setFolio(VUFechasUtil.convDateTxtF(Calendar.getInstance().getTime()));
		solicit.setIdEstado(1);
		solicit.setIdTramite(idTram);
		solicit.setUserRFC(rfcUser);
		
		this.iTramDao.insertSolic(solicit);
		
		//agregamos el detalle de la solicitud
		final VUDetalleSol detSol = new VUDetalleSol();
		detSol.setDetalle("Se ingresa");
		detSol.setFecDet(Calendar.getInstance().getTime());
		detSol.setIdSolicitud(solicit.getIdSolicitud());
		
		this.iTramDao.insertDetSolic(detSol);
		
		return VUTramConstants.OK;
	}
	
	/**
	 * Regresa liste de tramites disponibles
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public List<VUDeptoTramite> buscaTramActiv() throws VUException {
		LOGVU.debug("buscaTramActiv");
		return  this.iTramDao.getTramites();
	}

	@Override
	public List<VUSolicitud> buscaSolicAct(final String rfcUser) throws VUException {
		LOGVU.debug("buscaSolicAct");
		return this.iTramDao.getSolAct(rfcUser);
	}
	
	@Override
	public List<VUDetalleSol> buscaDetSolic(final Long idSolic) throws VUException {
		LOGVU.debug("buscaDetSolic");
		return this.iTramDao.getDetSol(idSolic);
	}
	@Override
	public List<VUSolicitud> buscaSolicFin(final String rfcUser) throws VUException {
		LOGVU.debug("buscaSolicFin");
		return this.iTramDao.getSolFin(rfcUser);
	}
	
	public List<TSolPersona> buscaNotSolic(final String rfcUser) throws VUException {
		LOGVU.debug("buscaNotSolic");
		return this.iTramDao.getSolPersona(rfcUser);
	}
	
	public Integer buscaNumNot(final String rfcUser) throws VUException {
		LOGVU.debug("buscaNumNotif");
		try {
			return this.iTramDao.getNotNum(rfcUser);
		} catch(Exception expo) {
			LOGVU.error(expo.getMessage());
		}
		return 0;
	}
	
	public byte[] reportSolicFin(final String rfcUser) throws VUException {
		final List<VUSolicitud> listSol = this.iTramDao.getSolFin(rfcUser);
		return this.generaPdf.generaArcSol(listSol, 
				messageSource.getMessage("sol.nav.lab.fin", null, VUTramConstants.LOCAL_MX), ":::::::::::::::::::");
	}
	
}
