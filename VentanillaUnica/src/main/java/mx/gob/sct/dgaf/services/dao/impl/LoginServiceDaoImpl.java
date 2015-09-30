package mx.gob.sct.dgaf.services.dao.impl;

import org.springframework.stereotype.Repository;

import mx.gob.sct.dgaf.services.dao.ILoginServiceDao;

@Repository("iLoginServiceDao")
public class LoginServiceDaoImpl implements ILoginServiceDao{
	
	public LoginServiceDaoImpl(){
		System.out.println("LoginDaoImpl inicializado por Spring !!");
	}

	@Override
	public String login() {
		// TODO Auto-generated method stub
		return  "Nombre Completo";
	}

}
