package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.BookAppointmentSpinnerBean;
import com.project.healingtouch.services.BookAppointmentServices;

public class BookAppointmentDoctorDetailsController extends HttpServlet{
	BookAppointmentSpinnerBean spinnerBean;
	JSONArray jsonArray;
	JSONObject jsonObject;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/Json");
		jsonArray = new JSONArray();
		jsonObject = new JSONObject();
		String patient_doctorname = req.getParameter("edittext_doctorname");
		String speciality = req.getParameter("edittext_speciality");
		System.out.println("=======patient_doctorname============"+patient_doctorname);
		System.out.println("=======speciality============"+speciality);
		
		BookAppointmentServices appointmentServices = new BookAppointmentServices();
		spinnerBean = appointmentServices.getDoctorDetailsServices(patient_doctorname,speciality);
		if (spinnerBean != null) {
			String cityname = spinnerBean.getHospital_city();
			String hospitalname = spinnerBean.getHospital_name();
			System.out.println("=====cityname====="+cityname);
			System.out.println("=====hospitalname====="+hospitalname);
			try {
				jsonObject.put("cityname", cityname);
				jsonObject.put("hospitalname", hospitalname);
				jsonArray.put(jsonObject);
				resp.getWriter().print(jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	}

}
