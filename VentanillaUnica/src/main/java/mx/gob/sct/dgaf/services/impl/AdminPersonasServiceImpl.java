package mx.gob.sct.dgaf.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sct.dgaf.exception.VUException;
import mx.gob.sct.dgaf.model.TCatTipoPersona;
import mx.gob.sct.dgaf.model.TPersona;
import mx.gob.sct.dgaf.services.IAdminPersonasService;
import mx.gob.sct.dgaf.services.dao.ICatTipoPersonaDao;
import mx.gob.sct.dgaf.services.dao.IPersonaDao;

@Service
public class AdminPersonasServiceImpl implements IAdminPersonasService {
	private static final Logger LOGVU = LoggerFactory.getLogger(AdminPersonasServiceImpl.class);

	@Autowired
	private ICatTipoPersonaDao catTipoPersonaDao;
	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<TCatTipoPersona> listTipoPersona() {
		// TODO Auto-generated method stub
		LOGVU.info("");
		return catTipoPersonaDao.getTipoPersona();
	}

	@Override
	public Integer savePersona(TPersona persona) {
		// TODO Auto-generated method stub
		try {
			personaDao.insertaPersona(persona);
		} catch (Exception e) {
			// TODO: handle exception
			LOGVU.error("Error al insertar una persona ",e.getCause());
			return 0;
		}

		return 1;
	}

	@Override
	public HashMap<String,TPersona> savePersonas(List<TPersona> personas)throws VUException {
		LOGVU.info("AdminPersonasServiceImpl ---->>>> ENTRAS savePersonas");
		// TODO Auto-generated method stub
		HashMap<String,TPersona> response =  new HashMap<String, TPersona>();
		try {
			for (TPersona tPersona : personas) {
				if(tPersona.getIdPersona()!=null){					
					personaDao.updatePersonaAsociada(personaCompleta(tPersona));
				}else{					
					personaDao.insertaPersona(personaCompleta(tPersona));
				}				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.put("Error al insertar <br>"+e.getMessage(), null);
			return response;
		}
		response.put("Las personas se insertaron exitosamente.", null);
		return response;
	}

	/**
	 * Metodo para completar el objeto peresona
	 * @param tPersona
	 * @return TPersona
	 */
	private TPersona personaCompleta(TPersona tPersona){
		tPersona.setIdTipoPersona(tPersona.getTipoPersona().getIdCatTipoPersona());
		String[] nombreDescompuesto = tPersona.getNombre().split(" ");	
		tPersona.setNombre(nombreDescompuesto[0]);
		if(nombreDescompuesto.length>1 && nombreDescompuesto.length<=3){
			tPersona.setNombre(nombreDescompuesto[0]);
			if(nombreDescompuesto.length == 2){
				tPersona.setApPaterno(nombreDescompuesto[1]);
			}
			if(nombreDescompuesto.length == 3){
				tPersona.setApPaterno(nombreDescompuesto[1]);
				tPersona.setApMaterno(nombreDescompuesto[2]);
			}
		}else if(nombreDescompuesto.length>3){			
			int tamanioNombre = nombreDescompuesto.length-2;
			for (int i = 1; i < tamanioNombre; i++) {
				tPersona.setNombre(nombreDescompuesto[i]+" ");
			}
			tPersona.setApPaterno(nombreDescompuesto[nombreDescompuesto.length-2]);
			tPersona.setApMaterno(nombreDescompuesto[nombreDescompuesto.length-1]);
		}
		if(tPersona.isActivo()){
			tPersona.setEstatusTramite(4);
		}else{
			tPersona.setEstatusTramite(5);
		}

		if(tPersona.getIdPersona()!=null){
			tPersona.setFechaActualiza(new Date());
		}else{
			tPersona.setFechaRegistro(new Date());
		}		
		return tPersona; 
	}

	@Override
	public TPersona getPersonaById(Long idPersona) {
		// TODO Auto-generated method stub
		return personaDao.getPersonaById(idPersona);
	}

	@Override
	public List<TPersona> getPersonasByPersonaAsociada(Long personaAsociada) {
		// TODO Auto-generated method stub
		List<TPersona> lstPersonas=null;
		try {
			lstPersonas = personaDao.getPersonasByPersonaAsociada(personaAsociada);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lstPersonas;
	}

	@Override
	public Integer updateEstatusByRFC(String rfc) {
		// TODO Auto-generated method stub
		int updateSucces = 0;

		try{
			updateSucces = personaDao.updateEstatusByRFC(rfc);
			
			System.out.println("Udated: "+updateSucces);
		}catch(Exception e){
			System.out.println("Error en Update");
			return 2;
		}
		
		//System.out.println("Update Satisfactorio");
		if(updateSucces>0)
			return 1;
		else
			return 2;
	}
	
	@Override
	public TPersona getConfirmDatesByRFC(HashMap<String, String> hashMapParameter) {
		// TODO Auto-generated method stub
		return personaDao.getConfirmDatesByRFC(hashMapParameter);
	}
	
	@Override
	public boolean updatePersonaAsociada(List<TPersona> personas) {
		// TODO Auto-generated method stub
		try {
			for (TPersona tPersona : personas) {
				personaDao.updatePersonaAsociada(personaCompleta(tPersona));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public TPersona getPersonaPorRC(HashMap<String, String> hashMapParameter) {
		// TODO Auto-generated method stub
		return personaDao.getPersonaPorRC(hashMapParameter);
	}

}
