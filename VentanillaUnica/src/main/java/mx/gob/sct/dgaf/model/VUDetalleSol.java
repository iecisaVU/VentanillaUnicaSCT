package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import mx.gob.sct.dgaf.util.VUFechasUtil;

@XmlRootElement
public class VUDetalleSol implements Serializable {

	private static final long serialVersionUID = 4018597149547946577L;
	
	protected Integer idDetSol;
	protected Long idSolicitud;
	protected Date fecDet;
	protected String detalle;
	protected Boolean activo;
	protected String folio;
	protected String fecView;
	
	public Integer getIdDetSol() {
		return idDetSol;
	}
	public void setIdDetSol(Integer idDetSol) {
		this.idDetSol = idDetSol;
	}
	public Long getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public Date getFecDet() {
		return fecDet;
	}
	public void setFecDet(Date fecDet) {
		this.fecDet = fecDet;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
		return VUFechasUtil.convDateTxt(fecDet);
	}
	public void setFecView(String fecView) {
		this.fecView = fecView;
	}
	
	
}
