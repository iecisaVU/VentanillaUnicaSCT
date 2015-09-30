package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TSolPersona extends TPersona implements Serializable {

	private static final long serialVersionUID = 3622868796271861425L;
	
	protected String nomComple;
	protected List<VUNotifSol> listNot = new ArrayList<VUNotifSol>();

	public List<VUNotifSol> getListNot() {
		return listNot;
	}

	public void setListNot(List<VUNotifSol> listNot) {
		this.listNot = listNot;
	}

	public String getNomComple() {
		final StringBuilder cadena = 
				new StringBuilder(this.checkVa(getNombre()))
		.append(" ").append(this.checkVa(getApPaterno()))
		.append(" ").append(this.checkVa(getApMaterno()));
		
		return cadena.toString();
	}

	public void setNomComple(String nomComple) {
		this.nomComple = nomComple;
	}
	
	private String checkVa(final String strVal) {
		if(null == strVal){
			return "";
		}
		return strVal.trim();
	}

}
