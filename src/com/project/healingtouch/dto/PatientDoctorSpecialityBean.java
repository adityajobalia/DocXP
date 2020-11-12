package com.project.healingtouch.dto;

public class PatientDoctorSpecialityBean {
	String title,doctorname,doctorspeciality,doctorhospitalname,doctorcity,
   doctorcontact,doctoremail,profileimage;
	public  PatientDoctorSpecialityBean() {
		
	}
	public PatientDoctorSpecialityBean(String doctorname2, String doctorspeciality2, String doctorhospitalname2,
			String doctorcity2, String doctorcontact2, String doctoremail2,String profilemage2) {
		this.doctorname=doctorname2;
		this.doctorspeciality=doctorspeciality2;
		this.doctorhospitalname=doctorhospitalname2;
		this.doctorcity=doctorcity2;
		this.doctorcontact=doctorcontact2;
		this.doctoremail=doctoremail2;
		this.profileimage=profilemage2;
	}
	
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDoctorspeciality() {
		return doctorspeciality;
	}
	public void setDoctorspeciality(String doctorspeciality) {
		this.doctorspeciality = doctorspeciality;
	}
	public String getDoctorhospitalname() {
		return doctorhospitalname;
	}
	public void setDoctorhospitalname(String doctorhospitalname) {
		this.doctorhospitalname = doctorhospitalname;
	}
	public String getDoctorcity() {
		return doctorcity;
	}
	public void setDoctorcity(String doctorcity) {
		this.doctorcity = doctorcity;
	}
	public String getDoctorcontact() {
		return doctorcontact;
	}
	public void setDoctorcontact(String doctorcontact) {
		this.doctorcontact = doctorcontact;
	}
	public String getDoctoremail() {
		return doctoremail;
	}
	public void setDoctoremail(String doctoremail) {
		this.doctoremail = doctoremail;
	}
	
	

}
