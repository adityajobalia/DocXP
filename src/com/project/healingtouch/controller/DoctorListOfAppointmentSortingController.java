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

import com.project.healingtouch.dto.DoctorListofAppointmenBean;
import com.project.healingtouch.services.DoctorListofAppointmentSortingServices;

public class DoctorListOfAppointmentSortingController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DoctorListofAppointmenBean bean;
	JSONArray array;
	JSONObject object;
	ArrayList<DoctorListofAppointmenBean> lst;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("==================================================================");
		System.out.println("====doc list of sorting apointment====");
		String doc_email=req.getParameter("email");
		String date=req.getParameter("date");
		bean= new DoctorListofAppointmenBean();
		bean.setDoc_email(doc_email);
		bean.setDoc_date(date);

		System.out.println("====go to DoctorListofAppointmentServices====");
		DoctorListofAppointmentSortingServices services =  new DoctorListofAppointmentSortingServices();
		lst=services.verifyDoctorListofAppointmentSortingData(bean);
		System.out.println("=====lst==="+lst);


		if(lst != null) {
			System.out.println("=====");
			array= new JSONArray();


			for(int i=0;i<lst.size();i++) {

				try {
					object= new JSONObject();
					
					String patient_name=lst.get(i).getName();
					object.put("patient_name", patient_name);
					System.out.println("==name=="+patient_name);

					String patient_email=lst.get(i).getEmail();
					object.put("patient_email",patient_email);
					System.out.println("=== bean.getEmail()=="+ patient_email);

					String patient_gender=lst.get(i).getGender();
					object.put("patient_gender",patient_gender);
					System.out.println("=== bean.getGender()=="+ patient_gender);

					String pateint_contact=lst.get(i).getContect();
					object.put("pateint_contact",pateint_contact);
					System.out.println("=== pateint_contact=="+ pateint_contact);

					String pateint_date=lst.get(i).getDate();
					object.put("pateint_date",pateint_date);
					System.out.println("=== pateint_date=="+ pateint_date);

					String patient_time=lst.get(i).getTime();
					object.put("patient_time",patient_time);
					System.out.println("=== patient_time=="+ patient_time);
					
					String patient_status=lst.get(i).getStatus();
					object.put("patient_status",patient_status);
					System.out.println("=== patient_status=="+ patient_status);
					array.put(object);
					System.out.println("=====array==="+array.toString());
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
