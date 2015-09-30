package mx.gob.sct.dgaf.services;

import mx.gob.sct.dgaf.model.TPerDatosPersona;

public interface IPersonaMedPrevenService {

	public TPerDatosPersona buscaPersonaPorCurp(String curp);
}
