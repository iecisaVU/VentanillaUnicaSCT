package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BTramite implements Serializable {

	private static final long serialVersionUID = 2230512352728794826L;

protected Date fecAct;
protected Date fecTram;
protected String folio;
protected String folioPago;
protected String folioTC;
protected Integer horaAct;
protected Integer idDepto;
protected Integer idEstado;
protected Integer idTramite;
protected String idUsua;
protected Integer impreso;
protected Integer permiso;
protected String placa;
protected String rfcEmp;
protected String serie;
protected Integer serieDup;

public Date getFecAct() {
	return fecAct;
}
public void setFecAct(Date fecAct) {
	this.fecAct = fecAct;
}
public Date getFecTram() {
	return fecTram;
}
public void setFecTram(Date fecTram) {
	this.fecTram = fecTram;
}
public String getFolio() {
	return folio;
}
public void setFolio(String folio) {
	this.folio = folio;
}
public String getFolioPago() {
	return folioPago;
}
public void setFolioPago(String folioPago) {
	this.folioPago = folioPago;
}
public String getFolioTC() {
	return folioTC;
}
public void setFolioTC(String folioTC) {
	this.folioTC = folioTC;
}
public Integer getHoraAct() {
	return horaAct;
}
public void setHoraAct(Integer horaAct) {
	this.horaAct = horaAct;
}
public Integer getIdDepto() {
	return idDepto;
}
public void setIdDepto(Integer idDepto) {
	this.idDepto = idDepto;
}
public Integer getIdEstado() {
	return idEstado;
}
public void setIdEstado(Integer idEstado) {
	this.idEstado = idEstado;
}
public Integer getIdTramite() {
	return idTramite;
}
public void setIdTramite(Integer idTramite) {
	this.idTramite = idTramite;
}
public String getIdUsua() {
	return idUsua;
}
public void setIdUsua(String idUsua) {
	this.idUsua = idUsua;
}
public Integer getImpreso() {
	return impreso;
}
public void setImpreso(Integer impreso) {
	this.impreso = impreso;
}
public Integer getPermiso() {
	return permiso;
}
public void setPermiso(Integer permiso) {
	this.permiso = permiso;
}
public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}
public String getRfcEmp() {
	return rfcEmp;
}
public void setRfcEmp(String rfcEmp) {
	this.rfcEmp = rfcEmp;
}
public String getSerie() {
	return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public Integer getSerieDup() {
	return serieDup;
}
public void setSerieDup(Integer serieDup) {
	this.serieDup = serieDup;
}

}
