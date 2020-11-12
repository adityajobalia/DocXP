package com.project.healingtouch.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.project.healingtouch.dto.DocRegisterBean;
import com.project.healingtouch.services.DocRegisterServices;

public class DocRegisterController extends HttpServlet {
	String path, fileName,filePath,imageFileName;
	File savedFile;
	boolean result;
	String dbpath;
	DocRegisterBean docRegisterBean;
	String doc_Name,doc_Email,doc_Pass,doc_Mobile,doc_speciality,doc_image,doctor_city,doctor_hospitalname,doctor_adress;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//response.setContentType("application/Json");
				System.out.println("============Fetching data from JSP form in doc");
				
					
				 Calendar cal = Calendar.getInstance();
		         int yyyy=cal.get(Calendar.YEAR);
		         int MM=cal.get(Calendar.MONTH);
		         int dd=cal.get(Calendar.DATE);
		         int mm = cal.get(Calendar.MINUTE);
		         int ss = cal.get(Calendar.SECOND);
		         int HH = cal.get(Calendar.HOUR);

		        imageFileName = "DJPEG_" + yyyy + "" + MM + "" + dd +"_"+ HH+""+mm+""+ss+".jpg";
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
							
							
							String path="F:/software/apache-tomcat-9.0.0.M26-windows-x86/apache-tomcat-9.0.0.M26/webapps/DocXp/uploadimage/doctorimage/";
							dbpath="uploadimage/doctorimage/"+imageFileName;
							File savedFile = new File(path+imageFileName);
							//File savedFile = new File("F:/software/apache-tomcat-9.0.0.M26-windows-x86/apache-tomcat-9.0.0.M26/webapps/UploadFile/uploadimage/"+fileItem.getName());
							
							
										
							fileItem.write(savedFile);

						} else {

							String register_doc_Name=fileItem.getFieldName();
							if (register_doc_Name.equals("doctor_name")) {
								 doc_Name=fileItem.getString();
								 System.out.println("register_Name"+doc_Name);
							
							}
							String register_doc_Email=fileItem.getFieldName();
							if (register_doc_Email.equals("doctor_email")) {
								 doc_Email=fileItem.getString();
								 System.out.println("register_doc_Email"+doc_Email);
							
							}
							String register_doc_Pass=fileItem.getFieldName();
							if (register_doc_Pass.equals("doctor_password")) {
								doc_Pass=fileItem.getString();
								 System.out.println("register_doc_Pass"+doc_Pass);
							
							}
							String register_doc_Mobile=fileItem.getFieldName();
							if (register_doc_Mobile.equals("doctor_mobile")) {
								doc_Mobile=fileItem.getString();
								 System.out.println("register_doc_Mobile"+doc_Mobile);
							
							}
							String register_doc_speciality=fileItem.getFieldName();
							if (register_doc_speciality.equals("doctor_speciality")) {
								doc_speciality=fileItem.getString();
								 System.out.println("register_doc_speciality"+doc_speciality);
							}
							String register_doc_city=fileItem.getFieldName();
							if (register_doc_city.equals("doctor_city")) {
								doctor_city=fileItem.getString();
								 System.out.println("register_doc_city"+doctor_city);
							}
							String register_doc_hospitalname=fileItem.getFieldName();
							if (register_doc_hospitalname.equals("doctor_hospitalname")) {
								doctor_hospitalname=fileItem.getString();
								 System.out.println("register_doc_hospital"+doctor_hospitalname);
							}
							String register_doc_addreess=fileItem.getFieldName();
							if (register_doc_addreess.equals("doctor_adress")) {
								doctor_adress=fileItem.getString();
								 System.out.println("register_doc_address"+doctor_adress);
							}
							


						}
					}
				}
					catch (FileUploadException e) {
						System.out.println(e);
					} catch (Exception e) {
						System.out.println(e);
					}
		        docRegisterBean=new DocRegisterBean();
		       docRegisterBean.setDocImage(dbpath);
		       System.out.println("========"+docRegisterBean.getDocImage());
		        if (doc_Name != null && !doc_Name.isEmpty()) {
					docRegisterBean.setDocName(doc_Name);
				}
				if (doc_Email != null && !doc_Email.isEmpty()) {
					docRegisterBean.setDocEmail(doc_Email);

				}
				if (doc_Pass != null && !doc_Pass.isEmpty()) {
					docRegisterBean.setDocPass(doc_Pass);
				}
				if (doc_Mobile != null && !doc_Mobile.isEmpty()) {
					docRegisterBean.setDocMobile(doc_Mobile);
				}
				if (doc_speciality != null && !doc_speciality.isEmpty()) {
					docRegisterBean.setDocSpeciality(doc_speciality);
				}
				if (doctor_city != null && !doctor_city.isEmpty()) {
					docRegisterBean.setDoccity(doctor_city);
				
				}
				if (doctor_hospitalname != null && !doctor_hospitalname.isEmpty()) {
					docRegisterBean.setDochospitalname(doctor_hospitalname);
				
				}
				if (doctor_adress != null && !doctor_adress.isEmpty()) {
					docRegisterBean.setDocaddress(doctor_adress);
				
				}
				
				DocRegisterServices docRegisterServices= new DocRegisterServices();
				result=docRegisterServices.verifyDoctorRegistration(docRegisterBean,resp);
		        
	}
}
