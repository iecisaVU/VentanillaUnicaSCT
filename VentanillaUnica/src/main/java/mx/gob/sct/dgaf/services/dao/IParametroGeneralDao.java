package mx.gob.sct.dgaf.services.dao;

import java.util.List;

import mx.gob.sct.dgaf.model.VUParametrosGenerales;

public interface IParametroGeneralDao {

	public VUParametrosGenerales getParametroByClave(String clave);
	public List<VUParametrosGenerales> getParametros();
}
