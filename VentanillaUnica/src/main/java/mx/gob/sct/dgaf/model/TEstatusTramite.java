package mx.gob.sct.dgaf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TEstatusTramite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1977368705066268960L;

	private Integer idEstatusTramite;
	
	private String descripcion;

	public Integer getIdEstatusTramite() {
		return idEstatusTramite;
	}

	public void setIdEstatusTramite(Integer idEstatusTramite) {
		this.idEstatusTramite = idEstatusTramite;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
