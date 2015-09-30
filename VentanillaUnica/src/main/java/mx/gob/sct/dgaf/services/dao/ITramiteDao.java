package mx.gob.sct.dgaf.services.dao;

import java.util.List;

import mx.gob.sct.dgaf.model.TSolPersona;
import mx.gob.sct.dgaf.model.VUDeptoTramite;
import mx.gob.sct.dgaf.model.VUDetalleSol;
import mx.gob.sct.dgaf.model.VUSolicitud;

public interface ITramiteDao {

	List<VUDeptoTramite> getTramites();
	void insertSolic(final VUSolicitud neoSolic);
	List<VUSolicitud> getSolAct(final String rfcUser);
	void insertDetSolic(final VUDetalleSol detSolic);
	List<VUDetalleSol> getDetSol(final Long idSolicitud);
	List<VUSolicitud> getSolFin(final String rfcUser);
	List<TSolPersona> getSolPersona(final String rfcUser);
	Integer getNotNum(final String rfcUser);

}
