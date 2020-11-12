package com.project.healingtouch.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.RegBean;
import com.project.healingtouch.services.RegisterServices;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterController extends HttpServlet {
	boolean result;
	RegBean bean;
	String path, fileName,filePath,imageFileName,dbpath;
	File savedFile;
	private static final long serialVersionUID = 1L;
/*public void init( ){
	      // Get the file location where it would be stored.
	       filePath = getServletContext().getInitParameter("file-path"); 
	   }*/

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * Fetching data from JSP form
		 * */
		response.setContentType("application/Json");
		System.out.println("============Fetching data from JSP form i reg");
		String register_Name = request.getParameter("register_edittext_name");
		System.out.println("register_Name"+register_Name);
		String register_Email = request.getParameter("register_edittext_email");
		System.out.println("register_Email"+register_Email);
		String register_Pass = request.getParameter("register_edittext_password");
		System.out.println("register_Pass"+register_Pass);
		String register_Mobile = request.getParameter("register_edittext_mobile");
		System.out.println("register_Mobile"+register_Mobile);
		System.out.println("============Fetching image ");
		String register_profileimg=request.getParameter("login_circular_logo");	
		System.out.println("=======================stringimage"+register_profileimg);
		
		//set image name
		 Calendar cal = Calendar.getInstance();
         int yyyy=cal.get(Calendar.YEAR);
         int MM=cal.get(Calendar.MONTH);
         int dd=cal.get(Calendar.DATE);
         int mm = cal.get(Calendar.MINUTE);
         int ss = cal.get(Calendar.SECOND);
         int HH = cal.get(Calendar.HOUR);

         imageFileName = "UJPEG_" + yyyy + "" + MM +1+ "" + dd +"_"+ HH+""+mm+""+ss+".jpg";

        
        String path="F:/software/apache-tomcat-9.0.0.M26-windows-x86/apache-tomcat-9.0.0.M26/webapps/DocXp/uploadimage/userimage/"+imageFileName;
 		dbpath="uploadimage/userimage/"+imageFileName;
 		
 		
 		//call fun for convert sting to image
        decoder(register_profileimg, path);
 		/*byte[] imageByteArray = Base64.decodeBase64(register_profileimg);
 		System.out.println("==========imagebytearray"+imageByteArray);
 	*/
		

		
		bean = new RegBean();
		bean.setUserImage(dbpath);
		/**
		 * Validating data
		 * */
		if (register_Name != null && !register_Name.isEmpty()) {
			bean.setUserName(register_Name);
		}
		if (register_Email != null && !register_Email.isEmpty()) {
			bean.setUserEmail(register_Email);

		}
		if (register_Pass != null && !register_Pass.isEmpty()) {
			bean.setUserPass(register_Pass);
		}
		if (register_Mobile != null && !register_Mobile.isEmpty()) {
			bean.setUserMobile(register_Mobile);
		}
		
		/**
		 * RegisterDB object is created to insert data in DB
		 * */
		RegisterServices services = new RegisterServices();
		result = services.verifyUserWhileRegister(bean);
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		if (result) {
			try {
				object.put("message", bean.getMessage());
				array.put(object);
				response.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (!result && bean.getMessage().equals("exists")) {
			try {
				object.put("message", bean.getMessage());
				array.put(object);
				response.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.err.println("Error occured while registration");
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
	}

}
