package com.project.healingtouch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.services.BookAppointmentSpinnerServices;

public class SpinnerDoctorController extends HttpServlet{
	boolean result;
	JSONArray array;
	JSONObject object;
	ArrayList<String> doctorlist;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		String hospital = req.getParameter("hospital");
		String speciality = req.getParameter("speciality");
		System.out.println("========hospital=========="+hospital);
		BookAppointmentSpinnerServices spinnerServices = new BookAppointmentSpinnerServices();
		doctorlist = spinnerServices.spinnerDoctorServices(hospital,speciality);
		
		if (doctorlist !=null) {
			System.out.println("======doctorlist=="+doctorlist);
			array = new JSONArray();
			try {
				object = new JSONObject();
				object.put("doctorlist", doctorlist);
				array.put(object);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.getWriter().print(array);
			System.out.println("array.toString()=="+array.toString());
		}
		else {
			System.out.println("No data found");
		}
		
	}

}
