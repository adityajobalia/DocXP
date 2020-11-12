package com.project.healingtouch.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTon implements Initialize{
	
	Connection con;
	private static SingleTon st = new SingleTon();
	
	
	private SingleTon()
	{
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSOWORD);
		} catch (ClassNotFoundException e) {
			
			System.out.println("Class is not loaded");
		} catch (SQLException e) {
			System.out.println("Data insertion is invalid");
		}
		
	}


	public static SingleTon getSt() {
		return st;
	}


	public static void setSt(SingleTon st) {
		SingleTon.st = st;
	}
	
	public Connection getcon()
	{
		return con;
		
	}
	
	public void setcon(Connection con)
	{
		
		this.con = con;
	}
	

}
