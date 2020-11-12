<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DocRegisterController" method="post" enctype="multipart/form-data">
<h3><center> <b><i>Doctor Registration</i></b></center></h3>
Name:<input type="text" name = "doctor_name" ><br><br>
Email:<input type="text" name = "doctor_email" ><br><br>
Password:<input type="password" name = "doctor_password" ><br><br>
Mobile:<input type="text" name = "doctor_mobile" ><br><br>
Speciality:<input type="text" name = "doctor_speciality" ><br><br>
City:<input type="text" name = "doctor_city" ><br><br>
Hospital Name:<input type="text" name = "doctor_hospitalname" ><br><br>
Adress:<input type="text" name = "doctor_adress" ><br><br>
Photo:<input type="file" name="doctor_image"><br><br>
<input type="submit" name = "doc_register" value = "Doc_Register">
</form>
</body>
</html>