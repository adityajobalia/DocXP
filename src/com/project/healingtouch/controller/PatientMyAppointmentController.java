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

import com.project.healingtouch.dto.PatientMyAppointmentBean;
import com.project.healingtouch.services.PatientMyAppointmentServices;

public class PatientMyAppointmentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PatientMyAppointmentBean bean= new PatientMyAppointmentBean();
	ArrayList<PatientMyAppointmentBean> arrayList;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("==================================================================");
		System.out.println("====pataint  apointment====");	
		
		String patient_email=req.getParameter("email");
		bean.setPatient_email(patient_email);
		
		PatientMyAppointmentServices services= new PatientMyAppointmentServices();
		arrayList=services.getPatientAppointmentData(bean);
		System.out.println("======array list-=="+arrayList);
		if(arrayList!=null) {
			JSONArray  array= new JSONArray();
			for(int i=0;i<arrayList.size();i++) {
				JSONObject object= new JSONObject();
				
				try {
					
					object.put("patient_nm",arrayList.get(i).getName() );
					System.out.println("===nm=="+arrayList.get(i).getName());
					
					
					String doc_nm=arrayList.get(i).getDoc_name();
					object.put("doc_name", doc_nm);
					System.out.println("===doc_nm=="+doc_nm);
					
					String hospital_nm= arrayList.get(i).getHospitalname();
					object.put("hospital_name", hospital_nm);
					System.out.println("=====hospital_nm===="+hospital_nm);
					
					String city=arrayList.get(i).getCity();
					object.put("city", city);
					System.out.println("=====city===="+city);
					
					String date=arrayList.get(i).getDate();
					object.put("date", date);
					System.out.println("====date=="+date);
					
					String time=arrayList.get(i).getTime();
					object.put("time", time);
					System.out.println("======time========"+time);
					
					array.put(object);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			resp.getWriter().print(array.toString());
			resp.getWriter().write(array.toString());
		}
		else {
			System.out.println("No data found==");
		}
		
		
		
	}

}
