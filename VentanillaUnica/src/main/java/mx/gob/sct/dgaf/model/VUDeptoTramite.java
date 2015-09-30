package mx.gob.sct.dgaf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VUDeptoTramite implements Serializable {

	private static final long serialVersionUID = -4403889445608884658L;

	protected Integer idDeptoTram;
	protected String descDeptoTram;
	protected String cveDeptoTram;
	protected Boolean activo;
	
	protected List<VUTramite> tramites = new ArrayList<VUTramite>();
	
	public Integer getIdDeptoTram() {
		return idDeptoTram;
	}
	public void setIdDeptoTram(Integer idDeptoTram) {
		this.idDeptoTram = idDeptoTram;
	}
	public String getDescDeptoTram() {
		return descDeptoTram;
	}
	public void setDescDeptoTram(String descDeptoTram) {
		this.descDeptoTram = descDeptoTram;
	}
	public String getCveDeptoTram() {
		return cveDeptoTram;
	}
	public void setCveDeptoTram(String cveDeptoTram) {
		this.cveDeptoTram = cveDeptoTram;
	}
	public Boolean isActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public void addTramite(final VUTramite tramite) {
		this.tramites.add(tramite);
	}
	
	public void addAllTramites(final List<VUTramite>  listTram) {
		this.tramites.addAll(listTram);
	}
	
	public void clearTramites() {
		this.tramites.clear();
	}
	public List<VUTramite> getTramites() {
		return tramites;
	}
	
	public void setTramites(List<VUTramite> tramites) {
		this.tramites = tramites;
	}
	
}
