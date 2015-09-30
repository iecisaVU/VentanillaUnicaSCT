package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import mx.gob.sct.dgaf.util.VUFechasUtil;

@XmlRootElement
public class VUNotifSol implements Serializable {

	private static final long serialVersionUID = -4403889445608884658L;

	protected Integer idNotSol;
	protected Long idSol;
	protected Date fecNot;
	protected String notificacion;
	protected Boolean activo;
	protected String folio;
	protected String fecView;
	
	public Integer getIdNotSol() {
		return idNotSol;
	}
	public void setIdNotSol(Integer idNotSol) {
		this.idNotSol = idNotSol;
	}
	public Long getIdSol() {
		return idSol;
	}
	public void setIdSol(Long idSol) {
		this.idSol = idSol;
	}
	public Date getFecNot() {
		return fecNot;
	}
	public void setFecNot(Date fecNot) {
		this.fecNot = fecNot;
	}
	public String getNotificacion() {
		return notificacion;
	}
	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	public String getFecView() {
		return VUFechasUtil.convDateTxtH(this.fecNot);
	}
	public void setFecView(String fecView) {
		this.fecView = fecView;
	}
	
	
}
