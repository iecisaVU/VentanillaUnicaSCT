package mx.gob.sct.dgaf.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.VUParametrosGenerales;
import mx.gob.sct.dgaf.services.IParametrosGeneralesService;
import mx.gob.sct.dgaf.services.dao.IParametroGeneralDao;

@Service
public class ParametrosGeneralesServiceImpl implements
		IParametrosGeneralesService {
@Autowired
private IParametroGeneralDao parametroGeneralDao;
	
	@Override
	public VUParametrosGenerales getParametrsByClave(String clave) throws VUException  {
		// TODO Auto-generated method stub
		return parametroGeneralDao.getParametroByClave(clave);
	}

	@Override
	public List<VUParametrosGenerales> getParametros() throws VUException {
		// TODO Auto-generated method stub
		return parametroGeneralDao.getParametros();
	}

}
