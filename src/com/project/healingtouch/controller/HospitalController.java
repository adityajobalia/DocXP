package com.project.healingtouch.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.project.healingtouch.dto.HospitalBean;
import com.project.healingtouch.services.HospitalServices;

public class HospitalController extends HttpServlet {
	HospitalBean bean= new HospitalBean();
	String path, fileName,filePath,imageFileName;
	File savedFile;
	boolean result;
	String dbpath;

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
		 Calendar cal = Calendar.getInstance();
         int yyyy=cal.get(Calendar.YEAR);
         int MM=cal.get(Calendar.MONTH);
         int dd=cal.get(Calendar.DATE);
         int mm = cal.get(Calendar.MINUTE);
         int ss = cal.get(Calendar.SECOND);
         int HH = cal.get(Calendar.HOUR);

        imageFileName = "HJPEG_" + yyyy + "" + MM + "" + dd +"_"+ HH+""+mm+""+ss+".jpg";
        if (!ServletFileUpload.isMultipartContent(req)) {
			// if not, we stop here
			PrintWriter writer = resp.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItems = upload.parseRequest(req);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					fileName = new File(fileItem.getName()).getName();
					
					
					String path="F:/software/apache-tomcat-9.0.0.M26-windows-x86/apache-tomcat-9.0.0.M26/webapps/DocXp/uploadimage/hospitalimage/";
					dbpath="uploadimage/hospitalimage/"+imageFileName;
					File savedFile = new File(path+imageFileName);
					
								
					fileItem.write(savedFile);

				} else {
					String hospital_nm=fileItem.getFieldName();
					if (hospital_nm.equals("hospital_nm")) {
						hospital_nm=fileItem.getString();
						 System.out.println("register_Name"+hospital_nm);
						 bean.setH_name(hospital_nm);
					
					}
					String hospital_locality=fileItem.getFieldName();
					if (hospital_locality.equals("hospital_locality")) {
						hospital_locality=fileItem.getString();
						 System.out.println("hospital_locality"+hospital_locality);
						 bean.setH_locality(hospital_locality);
					}
					String hospital_add=fileItem.getFieldName();
					if (hospital_add.equals("hospital_add")) {
						hospital_add=fileItem.getString();
						 System.out.println("register_doc_address"+hospital_add);
						 bean.setH_address(hospital_add);
					}
					String hospital_contact=fileItem.getFieldName();
					if (hospital_contact.equals("hospital_contact")) {
						hospital_contact=fileItem.getString();
						 System.out.println("register_doc_address"+hospital_contact);
						 bean.setH_contact(hospital_contact);
					}
					String hospital_website=fileItem.getFieldName();
					if (hospital_website.equals("hospital_website")) {
						hospital_website=fileItem.getString();
						 System.out.println("register_doc_address"+hospital_website);
						 bean.setH_website(hospital_website); 
					}
					String hospital_latitude=fileItem.getFieldName();
					if (hospital_latitude.equals("hospital_latitude")) {
						hospital_latitude=fileItem.getString();
						 System.out.println("hospital_latitude"+hospital_latitude);
						 bean.setLatitude(hospital_latitude);
						 
					}
					String hospital_longitude=fileItem.getFieldName();
					if (hospital_longitude.equals("hospital_longitude")) {
						hospital_longitude=fileItem.getString();
						 System.out.println("hospital_longitude"+hospital_longitude);
						bean.setLongitude(hospital_longitude);
						 
					}
					
					
				}
			}
		}
					
		catch (FileUploadException e) {
					System.out.println(e);
				} catch (Exception e) {
					System.out.println(e);
				}
		/*		
		String hospital_nm=req.getParameter("hospital_nm");
		
		String hospital_add=req.getParameter("hospital_add");
		
		String hospital_contact=req.getParameter("hospital_contact");
		
		String hospital_website= req.getParameter("hospital_website");
		*/
		bean.setH_image1(dbpath);
		System.out.println("======dbpath======"+dbpath);
		HospitalServices services= new HospitalServices();
		services.getHospitalData(bean,resp);
		
		
		
	
		
}
}