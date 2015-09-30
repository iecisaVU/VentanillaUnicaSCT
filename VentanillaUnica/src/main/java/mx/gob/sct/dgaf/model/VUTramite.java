package mx.gob.sct.dgaf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VUTramite implements Serializable {

	private static final long serialVersionUID = 5601350479436711714L;
	
	protected Integer idTramite;
	protected Integer idDeptoTram;
	protected String cveTram;
	protected String descTram;
	protected Boolean activo;
	protected String descDeptoTram;
	
	public Integer getIdTramite() {
		return idTramite;
	}
	public void setIdTramite(Integer idTramite) {
		this.idTramite = idTramite;
	}
	public Integer getIdDeptoTram() {
		return idDeptoTram;
	}
	public void setIdDeptoTram(Integer idDeptoTram) {
		this.idDeptoTram = idDeptoTram;
	}
	public String getCveTram() {
		return cveTram;
	}
	public void setCveTram(String cveTram) {
		this.cveTram = cveTram;
	}
	public String getDescTram() {
		return descTram;
	}
	public void setDescTram(String descTram) {
		this.descTram = descTram;
	}
	public Boolean isActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String getDescDeptoTram() {
		return descDeptoTram;
	}
	public void setDescDeptoTram(String descDeptoTram) {
		this.descDeptoTram = descDeptoTram;
	}
	
	
}
