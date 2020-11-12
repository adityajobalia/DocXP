package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.BookAppointmentBean;
import com.project.healingtouch.services.BookAppointmentServices;

public class BookAppointmentController extends HttpServlet{
	boolean result;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/Json");
		String patient_name = req.getParameter("bookappointment_patient_name");
		System.out.println("======="+patient_name);
		String patient_email = req.getParameter("bookappointment_patient_email");
		System.out.println("======="+patient_email);
		String patient_contact = req.getParameter("bookappointment_patient_contact");
		System.out.println("======="+patient_contact);
		String patient_gender = req.getParameter("bookappointment_patient_gender");
		System.out.println("======="+patient_gender);
		String patient_city = req.getParameter("bookappointment_patient_city");
		System.out.println("======="+patient_city);
		String speciality = req.getParameter("bookappointment_speciality");
		System.out.println("========"+speciality);
		String patient_doctor = req.getParameter("bookappointment_patient_doctor");
		System.out.println("======="+patient_doctor);
		String patient_hospital = req.getParameter("bookappointment_patient_hospital");
		System.out.println("======="+patient_hospital);
		String patient_date = req.getParameter("bookappointment_patient_date");
		System.out.println("======="+patient_date);
		String patient_time = req.getParameter("bookappointment_patient_time");
		System.out.println("======="+patient_time);
		
		BookAppointmentBean appointmentBean = new BookAppointmentBean();
		if (!patient_name.isEmpty()) {
			appointmentBean.setPatientName(patient_name);
		}
		if (!patient_email.isEmpty()) {
			appointmentBean.setPatientEmail(patient_email);
		}if (!patient_contact.isEmpty()) {
			appointmentBean.setPatientContact(patient_contact);
		}if (!patient_gender.isEmpty()) {
			appointmentBean.setPatientGender(patient_gender);
		}if (!patient_city.isEmpty()) {
			appointmentBean.setPatientCity(patient_city);
		}if (!patient_doctor.isEmpty()) {
			appointmentBean.setPatientDoctor(patient_doctor);
		}if (!patient_hospital.isEmpty()) {
			appointmentBean.setPatientHospital(patient_hospital);
		}if (!patient_date.isEmpty()) {
			appointmentBean.setPatientAppointmentDate(patient_date);
		}if (!patient_time.isEmpty()) {
			appointmentBean.setPatientAppointmentTime(patient_time);
		}if (!speciality.isEmpty()) {
			appointmentBean.setSpeciality(speciality);
		}
		
		BookAppointmentServices bookAppointmentServices = new BookAppointmentServices();
		result = bookAppointmentServices.appointmentServices(appointmentBean);
		
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		if (result) {
			try {
				object.put("message", appointmentBean.getMessage());
				array.put(object);
				resp.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.err.println("error occured while booking appointment");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
