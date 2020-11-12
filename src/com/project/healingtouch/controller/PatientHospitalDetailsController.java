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

import com.project.healingtouch.dto.PatientHospitalDetailsBean;
import com.project.healingtouch.services.PatientHospitalDetailsServices;

public class PatientHospitalDetailsController extends HttpServlet
{
	
	ArrayList<PatientHospitalDetailsBean> arrayList;
	PatientHospitalDetailsBean detailsBean;
	JSONArray array;
	JSONObject object;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("======PatientHospitalDetailsController======");
		PatientHospitalDetailsBean bean= new PatientHospitalDetailsBean();
		String hospital_name=req.getParameter("hospital_name");
		String hospital_locality=req.getParameter("hospital_locality");
		
		bean.setHospital_name(hospital_name);
		bean.setHospital_locality(hospital_locality);
		
		PatientHospitalDetailsServices services= new  PatientHospitalDetailsServices();
		detailsBean=services.getHospitalDetails(bean);
		detailsBean=services.getHospitalLatLong(bean);
		arrayList=services.getDoctorDetails(bean);
		
		
		if(detailsBean!= null && arrayList!= null) {
			array= new  JSONArray();
			for(int i=0;i<arrayList.size();i++) {
				try {
					object= new JSONObject();
					object.put("doctor_name", arrayList.get(i).getDoctor_name());
					object.put("doctor_speciality", arrayList.get(i).getDoctor_speciality());
					object.put("doctor_image", arrayList.get(i).getDoctor_image());
					System.out.println("=====arrayList.get(i).getDoctor_name()======="+arrayList.get(i).getDoctor_name());
					System.out.println("======arrayList.get(i).getDoctor_speciality()====="+arrayList.get(i).getDoctor_speciality());
					System.out.println("======arrayList.get(i).getDoctor_image()======"+arrayList.get(i).getDoctor_image());
					object.put("hospital_name", detailsBean.getHospital_name());
					object.put("hospital_address", detailsBean.getHospital_address());
					object.put("hospital_contact", detailsBean.getHospital_contact());
					object.put("hospital_website", detailsBean.getHospital_website());
					object.put("hospital_image", detailsBean.getHospital_image());
					
					object.put("hospital_lat", detailsBean.getH_lat());
					object.put("hospital_long", detailsBean.getH_long());
					System.out.println("====##detailsBean.getH_lat()======"+detailsBean.getH_lat());
					System.out.println("====##detailsBean.getH_long()======"+detailsBean.getH_long());
					
					
					System.out.println("====detailsBean.getHospital_name()======"+detailsBean.getHospital_name());
					System.out.println("=====detailsBean.getHospital_address()====="+detailsBean.getHospital_address());
					System.out.println("====detailsBean.getHospital_contact()======"+detailsBean.getHospital_contact());
					System.out.println("=====detailsBean.getHospital_website()====="+detailsBean.getHospital_website());
					System.out.println("=======detailsBean.getHospital_image()========"+detailsBean.getHospital_image());
					
					array.put(object);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			resp.getWriter().write(array.toString());
			resp.getWriter().print(array.toString());
			
		
		}
		else {
			System.out.println("====no data found=====");
		}
		
	}

}
