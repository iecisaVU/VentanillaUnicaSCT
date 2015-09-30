package mx.gob.sct.dgaf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RepReporte implements Serializable {

	private static final long serialVersionUID = -6378665711023226125L;

protected String reporte;
protected String rutaRep;
protected Integer cveReporte;
protected Integer cveTipoRep;
protected Integer activo;
protected Integer conexActi;

protected String fecDummy;

public String getReporte() {
	return reporte;
}
public void setReporte(String reporte) {
	this.reporte = reporte;
}
public String getRutaRep() {
	return rutaRep;
}
public void setRutaRep(String rutaRep) {
	this.rutaRep = rutaRep;
}
public Integer getCveReporte() {
	return cveReporte;
}
public void setCveReporte(Integer cveReporte) {
	this.cveReporte = cveReporte;
}
public Integer getCveTipoRep() {
	return cveTipoRep;
}
public void setCveTipoRep(Integer cveTipoRep) {
	this.cveTipoRep = cveTipoRep;
}
public Integer getActivo() {
	return activo;
}
public void setActivo(Integer activo) {
	this.activo = activo;
}
public Integer getConexActi() {
	return conexActi;
}
public void setConexActi(Integer conexActi) {
	this.conexActi = conexActi;
}
public String getFecDummy() {
	return fecDummy;
}
public void setFecDummy(String fecDummy) {
	this.fecDummy = fecDummy;
}
	
}
