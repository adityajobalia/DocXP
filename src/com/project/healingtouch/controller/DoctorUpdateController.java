package com.project.healingtouch.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.ProfileBean;
import com.project.healingtouch.services.ProfileServices;

/**
 * Servlet implementation class DoctorUpdateController
 */
public class DoctorUpdateController extends HttpServlet {
	public String field, message, email, name, password, mobile,image,imageFileName,dbpath;
	public ProfileBean bean = new ProfileBean();
	ProfileServices profileServices = new ProfileServices();
	boolean result;
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoctorUpdateController is invoked");
		field = request.getParameter("field");
		System.out.println("===field==="+field);
		PrintWriter writer = response.getWriter();
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		switch (field) {
		case "profileimage": {
			System.out.println("===image====");
			String proileimage=request.getParameter("profileimage");
			bean.setProfileimage(proileimage);
			System.out.println("======image"+proileimage);
			name = request.getParameter("name");
			System.out.println("=========name"+name);
			email = request.getParameter("email");
			System.out.println("======email"+email);
			bean.setPassword(request.getParameter("password"));
			System.out.println("======pass"+request.getParameter("password"));
		    bean.setMobile(request.getParameter("mobile"));
		    System.out.println("======mobile=="+request.getParameter("mobile"));
			bean.setName(name);
			bean.setEmail(email);
			bean.setOldEmail(email);
			bean.setField("profileimage");
			
			//set image name
			 Calendar cal = Calendar.getInstance();
	         int yyyy=cal.get(Calendar.YEAR);
	         int MM=cal.get(Calendar.MONTH);
	         int dd=cal.get(Calendar.DATE);
	         int mm = cal.get(Calendar.MINUTE);
	         int ss = cal.get(Calendar.SECOND);
	         int HH = cal.get(Calendar.HOUR);

	         imageFileName = "UJPEG_" + yyyy + "" + MM +1+ "" + dd +"_"+ HH+""+mm+""+ss+".jpg";

	        
	        String path="F:/software/apache-tomcat-9.0.0.M26-windows-x86/apache-tomcat-9.0.0.M26/webapps/DocXp/uploadimage/doctorimage/"+imageFileName;
	 		dbpath="uploadimage/doctorimage/"+imageFileName;
	 		
	 		System.out.println("======dbpath"+dbpath);
	 		
	 		//call fun for convert sting to image
	        decoder(proileimage, path);
	        System.out.println("==============---");
	        bean.setProfileimage(dbpath);
	        System.out.println("=======go to servicesr");
			result = profileServices.changeDoctorData(bean);
			if (result) {
				try {
					object.put("message", "success");
					array.put(object);
					writer.print(array);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Error in updating image...");
			}
			break;
		}
		case "password": {
			email = request.getParameter("email");
			password = request.getParameter("password");
			bean.setName(request.getParameter("name"));
			bean.setMobile(request.getParameter("mobile"));
			bean.setSpeciality(request.getParameter("speciality"));
			bean.setProfileimage(request.getParameter("profileimage"));
			bean.setPassword(password);
			bean.setEmail(email);
			bean.setOldEmail(email);
			bean.setField("password");
			result = profileServices.changeDoctorData(bean);
			if (result) {
				try {
					object.put("message", "success");
					array.put(object);
					writer.print(array);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Error in updating password...");
			}
			break;
		}
		case "email": {
			String oldEmail = request.getParameter("oldemail");
			email = request.getParameter("email");
			bean.setName(request.getParameter("name"));
			bean.setPassword(request.getParameter("password"));
			bean.setMobile(request.getParameter("mobile"));
			bean.setSpeciality(request.getParameter("speciality"));
			bean.setProfileimage(request.getParameter("profileimage"));
			bean.setEmail(email);
			bean.setOldEmail(oldEmail);
			bean.setField("email");
			result = profileServices.changeDoctorData(bean);
			if (result) {
				try {
					object.put("message", "success");
					array.put(object);
					writer.print(array);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Error in updating email...");
			}
			break;
		}
		case "mobile": {
			email = request.getParameter("email");
			mobile = request.getParameter("mobile");
			bean.setName(request.getParameter("name"));
			bean.setPassword(request.getParameter("password"));
			bean.setSpeciality(request.getParameter("speciality"));
			bean.setProfileimage(request.getParameter("profileimage"));
			bean.setEmail(email);
			bean.setOldEmail(email);
			bean.setMobile(mobile);
			bean.setField("mobile");
			result = profileServices.changeDoctorData(bean);
			if (result) {
				try {
					object.put("message", "success");
					array.put(object);
					writer.print(array);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Error in updating mobile...");
			}
			break;
		}
		default:
			break;
		}
	}
	public void decoder(String register_profileimg, String string) {
		try (FileOutputStream imageOutFile = new FileOutputStream(string)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.decodeBase64(register_profileimg);
			imageOutFile.write(imageByteArray);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		
	}

}
