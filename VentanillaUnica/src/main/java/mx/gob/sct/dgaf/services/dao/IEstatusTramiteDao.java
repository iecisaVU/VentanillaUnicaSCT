package mx.gob.sct.dgaf.services.dao;

import java.util.List;

import mx.gob.sct.dgaf.model.TEstatusTramite;

public interface IEstatusTramiteDao {

	public List<TEstatusTramite> getEstatus();
	
	public TEstatusTramite getEstatusById(Integer idEstatus);
	
	
}
