package mx.gob.sct.dgaf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GRLPais implements Serializable {

	private static final long serialVersionUID = -1041325174574046654L;

	protected String abreviatura;
	
	protected String nombre;
	
	protected String cvePais;

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCvePais() {
		return cvePais;
	}

	public void setCvePais(String cvePais) {
		this.cvePais = cvePais;
	}
	
	
}
