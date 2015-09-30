package mx.gob.sct.dgaf.services;

import java.util.List;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.TSolPersona;
import mx.gob.sct.dgaf.model.VUDeptoTramite;
import mx.gob.sct.dgaf.model.VUDetalleSol;
import mx.gob.sct.dgaf.model.VUSolicitud;

public interface ITramiteService {
	String agregaNuevoTram(final Integer idTram, final String rfcUser) throws VUException;
	List<VUDeptoTramite> buscaTramActiv() throws VUException;
	List<VUSolicitud> buscaSolicAct(final String rfcUser) throws VUException;
	List<VUDetalleSol> buscaDetSolic(final Long idSolic) throws VUException;
	List<VUSolicitud> buscaSolicFin(final String rfcUser) throws VUException;
	List<TSolPersona> buscaNotSolic(final String rfcUser) throws VUException;
	Integer buscaNumNot(final String rfcUser) throws VUException;
	byte[] reportSolicFin(final String rfcUser) throws VUException;
}
