package com.project.healingtouch.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.ChangePasswordBean;
import com.project.healingtouch.services.OTPServices;

/**
 * Servlet implementation class MailServlet
 */
public class MailServlet extends HttpServlet {
	String to_email,otp;
	public boolean flag; 
	private static final long serialVersionUID = 1L;
	static String username = "htouch.jnext@gmail.com";
	static String password = "Healing@touch";
	JSONArray array;
	JSONObject object;
	ChangePasswordBean bean;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Servlet is invoked====");
		to_email = request.getParameter("email");
		otp = request.getParameter("otp");
		PrintWriter out = response.getWriter();
		bean = new ChangePasswordBean();
		OTPServices services = new OTPServices();
		bean.setEmail(to_email);
		flag = services.verifyEmail(bean);
		if (flag) {
			Properties properties = new Properties();
			// Setup mail server
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");

			// Get the default Session object.
			Session session = Session.getDefaultInstance(properties,new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(username, password);
				}
			});

			// Set response content type
			response.setContentType("text/html");

			try {
				// Create a default MimeMessage object.
				MimeMessage message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(username));

				// Set To: header field of the header.
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to_email));

				// Set Subject: header field
				message.setSubject("Forget Password");

				// Now set the actual message
				message.setText("Enter this One-Time-Password "+otp+ " to reset your Password."+"\n"+"Note: Please don't disclose this OTP to anyone.");
				// Send message
				Transport.send(message);
				
				 array = new JSONArray();
				 object = new JSONObject();
				try {
					object.put("message", "OTP sent successfully");
					object.put("auth", "success");
					object.put("user", bean.getAuth());
					array.put(object);
					out.print(array);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}
		else {
			 array = new JSONArray();
			 object = new JSONObject();
			try {
				object.put("auth", "failure");
				array.put(object);
				out.print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}