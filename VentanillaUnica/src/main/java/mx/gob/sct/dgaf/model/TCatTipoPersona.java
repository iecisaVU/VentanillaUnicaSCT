package mx.gob.sct.dgaf.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TCatTipoPersona {

	/**
	 * Identificador del catalogo
	 */
	private Integer idCatTipoPersona;
	/**
	 * Descripcion del catlogo
	 */
	private String descripcion;
	/**
	 * Estatus del catalogo 0 incativo 1 activo
	 */
	private boolean estatus;


	public Integer getIdCatTipoPersona() {
		return idCatTipoPersona;
	}

	public void setIdCatTipoPersona(Integer idCatTipoPersona) {
		this.idCatTipoPersona = idCatTipoPersona;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
