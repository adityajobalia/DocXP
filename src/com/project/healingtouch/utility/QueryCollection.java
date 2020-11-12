package com.project.healingtouch.utility;

public interface QueryCollection {
	public static final String DOCTOR_VERIFY_QUERY = "Select d_password from htouch.docuser where d_email = ?";
	public static final String REGISTER_QUERY = "insert into htouch.reguser (rname,remail,rpass,rmobile,rprofileimage) values(?,?,?,?,?)";
	public static final String DOCTOR_REGISTER_QUERY = "insert into htouch.docuser (d_name,d_email,d_password,d_mobile,d_speciality,d_hospitalname,d_city,d_address,d_profileimage) values(?,?,?,?,?,?,?,?,?)";
	public static final String LOGIN_QUERY = "insert into htouch.loguser (lemail,lpass) values(?,?)";
	public static final String DOCTOR_LOGIN_QUERY = "Select * from htouch.docuser where d_email = ? and d_password = ?";
	public static final String DOCTOR_REGISTER_VERIFY_QUERY = "Select d_password from htouch.docuser where d_email = ?";
	public static final String REGISTER_VERIFY_QUERY = "Select rpass from htouch.reguser where remail = ?";
	public static final String LOGIN_VERIFY_QUERY = "Select * from htouch.reguser where remail = ? and rpass = ?";
	public static final String PATIENT_BOOKAPPOINTMENT_QUERY = "insert into htouch.bookappointment (patient_name,patient_email,patient_contact,patient_gender,patient_city,patient_doctor,patient_hospital,patient_date,patient_time,patient_status,patient_doc_speciality) values (?,?,?,?,?,?,?,?,?,?,?)";
	public static final String PATIENT_PROFILE_QUERY = "Select * from htouch.reguser where remail = ? and rpass = ?";
	public static final String PATIENT_DATA_UPDATE_REGISTRATION = "Update htouch.reguser set rname = ? , remail = ? , rpass = ? , rmobile = ? , rprofileimage=? where remail = ?";
	public static final String PATIENT_DATA_UPDATE_LOGIN = "Update htouch.loguser set lemail = ? , lpass = ? where lemail = ?";
	public static final String PATIENT_PASSWORD_UPDATE_REGISTRATION = "Update htouch.reguser set rpass = ? where remail = ?";
	public static final String PATIENT_PASSWORD_UPDATE_LOGIN = "Update htouch.loguser set lpass = ? where lemail = ?";
	public static final String DOCTOR_PASSWORD_UPDATE= "Update htouch.docuser set d_password = ? where d_email = ?";
	public static final String DOCTOR_DATA_UPDATE_QUERY = "Update htouch.docuser set d_name = ? , d_email = ? , d_password = ? , d_mobile = ? ,d_profileimage=? where d_email = ?";
	public static final String LIST_OF_APPOINTMENT_DOCTOR_DATA="Select * from htouch.docuser where d_email=?";
	public static final String DOC_LIST_OF_APPOINTMENT_DATA="select * from htouch.bookappointment where patient_doctor=? and patient_hospital=? and patient_status = ?";
	public static final String DOC_LIST_OF_APPOINTMENT_SORTED_DATA="select * from htouch.bookappointment where patient_doctor=? and patient_hospital=? and patient_date=? and patient_status = ?";
	public static final String LIST_OF_APPOINTMENT_PATIENT_DATA="select * from htouch.bookappointment where patient_email=? and patient_status=?";
	public static final String HOSPITAL_QUERY="insert into htouch.hospital(h_name,h_locality,h_address,h_latitude,h_longitude,h_contact,h_website,h_profile) values(?,?,?,?,?,?,?,?) ";	
	public static final String HOSPITAL_VERIFY_QUERY="select * from htouch.hospital Where h_website = ?";	
	public static final String REMOVE_DATA_FROM_LIST="delete from htouch.bookappointment where patient_name = ? and patient_email = ? and patient_date = ? and patient_time = ? ";
	public static final String HOSPITAL_LIST_DATA="select * from htouch.hospital";
	public static final String HOSPITAL_LIST_DATA_BY_CITY="select * from htouch.hospital where h_locality = ?";
	public static final String DOCTOR_SPECIALITY_lIST="select * from htouch.docuser where d_speciality = ?";
	public static final String CONFIRM_UPDATE_APPOINTMENT="update htouch.bookappointment set patient_status = ? where patient_name = ? and patient_email = ? and patient_date = ? and patient_time = ?";
	public static final String DOC_CONFIRM_LIST_OF_APPOINTMENT_DATA="select * from htouch.bookappointment where patient_doctor= ? and patient_hospital= ? and patient_status = ?";
	public static final String HOSPITAL_DETAILS="select * from htouch.hospital where h_name = ? and h_locality = ?";
	public static final String HOSPITAL_DETAILS_DOCTOR_LIST="select * from htouch.docuser where d_hospitalname = ? and d_city = ?";
	public static final String HOSPITAL_LATLONG="select * from  htouch.hospital where h_locality = ?";
	public static final String HOSPITAL_DATA_LATLONG="select * from  htouch.hospital where h_name = ? and h_locality = ?";
	public static final String ADD_EMERGENCY_CONTACT_DATA="insert into htouch.emergencycontact(c_name,c_email,c_mobile,c_login_email) values(?,?,?,?)";
	public static final String UPDATE_EMERGENCY_CONTACT_DATA="update htouch.emergencycontact set c_name = ? , c_email = ?, c_mobile = ? where c_login_email = ?";
	public static final String GET_EMERGENCY_CONTACT_DATA="select * from htouch.emergencycontact where c_login_email = ?";
	public static final String DOCTOR_DRAWER_DATA="select * from htouch.docuser where d_email = ?";
	public static final String PATIENT_DRAWER_DATA="select * from htouch.reguser where remail = ?";
	public static final String GET_DOCTOR_DETAILS = "select * from htouch.docuser where d_name = ? and d_speciality = ?";
	public static final String SPINNER_CITY_DATA = "select d_city from htouch.docuser";	
	public static final String SPINNER_DOCTOR_DATA = "select d_name from htouch.docuser where d_hospitalname = ? and d_speciality = ?";	
	public static final String SPINNER_HOSPITAL_DATA = "select d_hospitalname from htouch.docuser where d_speciality = ? and d_city = ?";		
	public static final String SPINNER_SPECIALITY_DATA = "select d_speciality from htouch.docuser where d_city = ?";
		
	//public static final String SPINNER_DOCTOR_DATA = "select d_name from htouch.docuser";
	//public static final String SPINNER_CITY_DATA = "select d_city from htouch.docuser";
	//public static final String SPINNER_HOSPITAL_DATA = "select d_hospitalname from htouch.docuser";	
	//public static final String REJECT_EMERGENCY_CONTACT_DATA="delete  from htouch.emergencycontact where c_login_email = ? and c_name = ?";
	
	public static final String UPDATE_PATIENT_TOKEN = "update htouch.loguser set token = ? where lemail = ?";
	public static final String UPDATE_DOCTOR_TOKEN = "update htouch.docuser set d_token = ? where d_email = ?";
	public static final String GET_DOCTOR_TOKEN = "select d_token from htouch.docuser where d_name = ?";
	public static final String GET_PATIENT_TOKEN = "select token from htouch.loguser where lemail = ?";
	
	
	









}
