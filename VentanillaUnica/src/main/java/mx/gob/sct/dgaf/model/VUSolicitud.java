package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import mx.gob.sct.dgaf.util.VUFechasUtil;

@XmlRootElement
public class VUSolicitud implements Serializable {

	private static final long serialVersionUID = -3049959191879571453L;
	
	protected Long idSolicitud;
	protected String userRFC;
	protected Integer idTramite;
	protected String folio;
	protected Integer consecutivo;
	protected Integer idEstado;
	protected Date fechaReg;
	protected Date fechaFinSol;
	protected Boolean activo;
	protected Boolean concluido;
	protected VUTramite tramite;
	protected VUEstadoSol estSol;
	protected String fecView;
	
	public Long getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getUserRFC() {
		return userRFC;
	}
	public void setUserRFC(String userRFC) {
		this.userRFC = userRFC;
	}
	public Integer getIdTramite() {
		return idTramite;
	}
	public void setIdTramite(Integer idTramite) {
		this.idTramite = idTramite;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public Integer getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public Date getFechaFinSol() {
		return fechaFinSol;
	}
	public void setFechaFinSol(Date fechaFinSol) {
		this.fechaFinSol = fechaFinSol;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Boolean isConcluido() {
		return concluido;
	}
	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}
	public VUTramite getTramite() {
		return tramite;
	}
	public void setTramite(VUTramite tramite) {
		this.tramite = tramite;
	}
	public VUEstadoSol getEstSol() {
		return estSol;
	}
	public void setEstSol(VUEstadoSol estSol) {
		this.estSol = estSol;
	}
	public String getFecView() {
		return VUFechasUtil.convDateTxt(fechaReg);
	}
	public void setFecView(String fecView) {
		this.fecView = fecView;
	}
	
}
