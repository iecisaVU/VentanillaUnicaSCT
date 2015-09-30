package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7867243706491553168L;

	
	private Long idPersona;	
	
	private String nombre;
	
	private String apPaterno;
	
	private String apMaterno;
	
	private String rfc;
	
	private String razonSocial;
	
	private String curp;
	
	private String email;
	
	private TCatTipoPersona tipoPersona;
	
	private Integer  idTipoPersona;
	
	private Integer estatusTramite;
	
	private Long personaAsociada;
	
	private boolean activo;
	
	private Date fechaRegistro;
	
	private Date fechaActualiza;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TCatTipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TCatTipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Integer getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Integer getEstatusTramite() {
		return estatusTramite;
	}

	public void setEstatusTramite(Integer estatusTramite) {
		this.estatusTramite = estatusTramite;
	}

	public Long getPersonaAsociada() {
		return personaAsociada;
	}

	public void setPersonaAsociada(Long personaAsociada) {
		this.personaAsociada = personaAsociada;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualiza() {
		return fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}


}
