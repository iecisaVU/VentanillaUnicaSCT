package mx.gob.sct.dgaf.services.dao;

import java.util.List;

import java.util.HashMap;

import mx.gob.sct.dgaf.model.TPersona;

public interface IPersonaDao {

	public TPersona getPersonaLogin();

	public Long insertaPersona(TPersona persona);
	
	public TPersona getPersonaById(Long idPersona);
	
	public List<TPersona> getPersonasByPersonaAsociada(Long personaAsociada);
	
	public TPersona getPersonaPorRC(HashMap<String, String> hashMapParameter);
	
	public boolean updatePersonaAsociada(TPersona persona);
	
	public Integer updateEstatusByRFC(String rfc); //huribe
	
	public TPersona getConfirmDatesByRFC(HashMap<String, String> hashMapParameter);    //huribe
}
