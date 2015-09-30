package mx.gob.sct.dgaf.util;

import java.io.Serializable;

import org.springframework.core.io.Resource;

public class FilesBean implements Serializable {
	
	private static final long serialVersionUID = -9055623534758236227L;
	private Resource fileImgSello;
	private Resource fileImgSCT;
	private Resource fileSctImg;
	private Resource plantXLS;
	
	public Resource getFileImgSello() {
		return fileImgSello;
	}
	public void setFileImgSello(Resource fileImgSello) {
		this.fileImgSello = fileImgSello;
	}
	
	public Resource getPlantXLS() {
		return plantXLS;
	}
	public void setPlantXLS(Resource plantXLS) {
		this.plantXLS = plantXLS;
	}
	public Resource getFileImgSCT() {
		return fileImgSCT;
	}
	public void setFileImgSCT(Resource fileImgSCT) {
		this.fileImgSCT = fileImgSCT;
	}
	public Resource getFileSctImg() {
		return fileSctImg;
	}
	public void setFileSctImg(Resource fileSctImg) {
		this.fileSctImg = fileSctImg;
	}
	
	
}
