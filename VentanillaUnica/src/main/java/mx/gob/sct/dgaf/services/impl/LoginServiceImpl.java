package mx.gob.sct.dgaf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sct.dgaf.services.ILoginService;
import mx.gob.sct.dgaf.services.dao.ILoginServiceDao;

@Service("iLoginService")
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	ILoginServiceDao iLoginServiceDao;
	
	public void setLoginDAO(ILoginServiceDao iLoginServiceDao) {
		this.iLoginServiceDao = iLoginServiceDao;
	}

	@Override
	public String login() {
		// TODO Auto-generated method stub
		return iLoginServiceDao.login();
	}

}
