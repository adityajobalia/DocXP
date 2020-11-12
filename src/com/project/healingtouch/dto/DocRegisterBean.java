package com.project.healingtouch.dto;

import java.io.Serializable;

public class DocRegisterBean  implements Serializable {
	private String docName;
	private String docPass;
	private String docEmail;
	private String docMobile;
	private String message;
	private String docImage;
	private String docSpeciality;
	private String doccity,docaddress,dochospitalname,token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDoccity() {
		return doccity;
	}
	public void setDoccity(String doccity) {
		this.doccity = doccity;
	}
	public String getDocaddress() {
		return docaddress;
	}
	public void setDocaddress(String docaddress) {
		this.docaddress = docaddress;
	}
	public String getDochospitalname() {
		return dochospitalname;
	}
	public void setDochospitalname(String dochospitalname) {
		this.dochospitalname = dochospitalname;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocPass() {
		return docPass;
	}
	public void setDocPass(String docPass) {
		this.docPass = docPass;
	}
	public String getDocEmail() {
		return docEmail;
	}
	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}
	public String getDocMobile() {
		return docMobile;
	}
	public void setDocMobile(String docMobile) {
		this.docMobile = docMobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDocImage() {
		return docImage;
	}
	public void setDocImage(String docImage) {
		this.docImage = docImage;
	}
	public String getDocSpeciality() {
		return docSpeciality;
	}
	public void setDocSpeciality(String docSpeciality) {
		this.docSpeciality = docSpeciality;
	}
	
}
