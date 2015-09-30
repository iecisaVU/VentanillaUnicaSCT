package mx.gob.sct.dgaf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VUEstadoSol implements Serializable {

	private static final long serialVersionUID = 5021967190534030046L;
	
	protected Integer idEstSol;
	protected String cveEstSol;
	protected String descEst;
	protected Boolean activo;
	
	public Integer getIdEstSol() {
		return idEstSol;
	}
	public void setIdEstSol(Integer idEstSol) {
		this.idEstSol = idEstSol;
	}
	public String getCveEstSol() {
		return cveEstSol;
	}
	public void setCveEstSol(String cveEstSol) {
		this.cveEstSol = cveEstSol;
	}
	public String getDescEst() {
		return descEst;
	}
	public void setDescEst(String descEst) {
		this.descEst = descEst;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
