package mx.gob.sct.dgaf.services.dao;

import mx.gob.sct.dgaf.model.TPerDatosPersona;

public interface IPersonaMedPrevenDao {

	public TPerDatosPersona getDatosPersonaByCurp(String curp);
}
