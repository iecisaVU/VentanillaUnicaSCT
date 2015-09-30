package mx.gob.sct.dgaf.util;

import java.io.Serializable;


public class ContentManagerDocument implements Serializable {
	
	private static final long serialVersionUID = -9055623534758236227L;
	private String  uploadServerName;
	private String  uploadUserId;
	private String  uploadPassword;
	
	private String[] uploadValues;
	private String[] uploadKeys;	
		
	private String downloadAddress;
	private String downloadUser;
	private String downloadPassword;
	private String downloadBase;
	
	private String[] downloadValues;
	private String[] downloadKeys;
	private String[] downloadOperators;
	public String getUploadServerName() {
		return uploadServerName;
	}
	public void setUploadServerName(String uploadServerName) {
		this.uploadServerName = uploadServerName;
	}
	public String getUploadUserId() {
		return uploadUserId;
	}
	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}
	public String getUploadPassword() {
		return uploadPassword;
	}
	public void setUploadPassword(String uploadPassword) {
		this.uploadPassword = uploadPassword;
	}
	public String[] getUploadValues() {
		return uploadValues;
	}
	public void setUploadValues(String[] uploadValues) {
		this.uploadValues = uploadValues;
	}
	public String[] getUploadKeys() {
		return uploadKeys;
	}
	public void setUploadKeys(String[] uploadKeys) {
		this.uploadKeys = uploadKeys;
	}
	public String getDownloadAddress() {
		return downloadAddress;
	}
	public void setDownloadAddress(String downloadAddress) {
		this.downloadAddress = downloadAddress;
	}
	public String getDownloadUser() {
		return downloadUser;
	}
	public void setDownloadUser(String downloadUser) {
		this.downloadUser = downloadUser;
	}
	public String getDownloadPassword() {
		return downloadPassword;
	}
	public void setDownloadPassword(String downloadPassword) {
		this.downloadPassword = downloadPassword;
	}
	public String getDownloadBase() {
		return downloadBase;
	}
	public void setDownloadBase(String downloadBase) {
		this.downloadBase = downloadBase;
	}
	public String[] getDownloadValues() {
		return downloadValues;
	}
	public void setDownloadValues(String[] downloadValues) {
		this.downloadValues = downloadValues;
	}
	public String[] getDownloadKeys() {
		return downloadKeys;
	}
	public void setDownloadKeys(String[] downloadKeys) {
		this.downloadKeys = downloadKeys;
	}
	public String[] getDownloadOperators() {
		return downloadOperators;
	}
	public void setDownloadOperators(String[] downloadOperators) {
		this.downloadOperators = downloadOperators;
	}
	


	
	
}
