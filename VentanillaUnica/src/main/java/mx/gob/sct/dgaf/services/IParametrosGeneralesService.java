package mx.gob.sct.dgaf.services;

import java.util.List;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.VUParametrosGenerales;

public interface IParametrosGeneralesService {

	public VUParametrosGenerales getParametrsByClave(String clave) throws VUException;
	public List<VUParametrosGenerales> getParametros() throws VUException;
}
