package mx.gob.sct.dgaf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sct.dgaf.model.TPerDatosPersona;
import mx.gob.sct.dgaf.services.IPersonaMedPrevenService;
import mx.gob.sct.dgaf.services.dao.IPersonaMedPrevenDao;
@Service
public class PersonaMedPrevenServiceImpl implements IPersonaMedPrevenService {

@Autowired
private IPersonaMedPrevenDao medPrevenDao;
	@Override
	public TPerDatosPersona buscaPersonaPorCurp(String curp) {
		// TODO Auto-generated method stub
		return medPrevenDao.getDatosPersonaByCurp(curp);
	}

}
