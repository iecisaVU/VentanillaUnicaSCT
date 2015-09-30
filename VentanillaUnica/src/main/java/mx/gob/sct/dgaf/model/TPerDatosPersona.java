package mx.gob.sct.dgaf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class TPerDatosPersona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039948792851679624L;

	private Long  icvePersonal; 
	
	private String cNombre;
	
	private String capPaterno;
	
	private String capMaterno;
	
	private String cRfc;
	
	private String cHomoClave;
	
	private String cCurp;

	public Long getIcvePersonal() {
		return icvePersonal;
	}

	public void setIcvePersonal(Long icvePersonal) {
		this.icvePersonal = icvePersonal;
	}

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	public String getCapPaterno() {
		return capPaterno;
	}

	public void setCapPaterno(String capPaterno) {
		this.capPaterno = capPaterno;
	}

	public String getCapMaterno() {
		return capMaterno;
	}

	public void setCapMaterno(String capMaterno) {
		this.capMaterno = capMaterno;
	}

	public String getcRfc() {
		return cRfc;
	}

	public void setcRfc(String cRfc) {
		this.cRfc = cRfc;
	}

	public String getcHomoClave() {
		return cHomoClave;
	}

	public void setcHomoClave(String cHomoClave) {
		this.cHomoClave = cHomoClave;
	}

	public String getcCurp() {
		return cCurp;
	}

	public void setcCurp(String cCurp) {
		this.cCurp = cCurp;
	}
	
	
	
	


}
