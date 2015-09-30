package mx.gob.sct.dgaf.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sct.dgaf.services.ICatalogoService;
import mx.gob.sct.dgaf.services.dao.ICatalogosDao;

@Service
public class CatalogoImpl implements ICatalogoService {

	private static final Logger LOGVU = LoggerFactory.getLogger(CatalogoImpl.class);
	
	@Autowired
	private ICatalogosDao iCatalogosDao;
	
	
	
	@Override
	public Long getSecuenciaInodocto() {
		// TODO Auto-generated method stub
		return iCatalogosDao.getSecuenciaInodocto();
	}



	@Override
	public void getActSecuenciaInodocto() {
		iCatalogosDao.getActSecuenciaInodocto();
	}

}
