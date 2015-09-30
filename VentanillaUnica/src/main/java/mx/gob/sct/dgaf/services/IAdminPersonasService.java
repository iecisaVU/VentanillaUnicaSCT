package mx.gob.sct.dgaf.services;

import java.util.HashMap;
import java.util.List;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.TCatTipoPersona;
import mx.gob.sct.dgaf.model.TPersona;

public interface IAdminPersonasService {

	public List<TCatTipoPersona> listTipoPersona();
	public Integer savePersona(TPersona persona);
	public HashMap<String,TPersona> savePersonas(List<TPersona> personas) throws VUException;
	public TPersona getPersonaById(Long idPersona);
	public List<TPersona>getPersonasByPersonaAsociada(Long personaAsociada);
	public TPersona getPersonaPorRC(HashMap<String, String> hashMapParameter);
	public boolean updatePersonaAsociada(List<TPersona> personas);
	public Integer updateEstatusByRFC(String rfc);  //huribe
	public TPersona getConfirmDatesByRFC(HashMap<String, String> hashMapParameter);    //huribe
}
