<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital</title>
</head>
<body>
<form action="HospiatlController" method="post" enctype="multipart/form-data">
<h3><center> <b><i>Hospital Registration</i></b></center></h3>
Hospital Name:<input type="text" name = "hospital_nm" ><br><br>
Hospital Locality:<input type="text" name = "hospital_locality" ><br><br>
Hospital Address:<input type="text" name = "hospital_add" ><br><br>
Hospital Contact:<input type="text" name = "hospital_contact" ><br><br>
Hospital Website<input type="text" name = "hospital_website" ><br><br>
Latitude:<input type="text" name="hospital_latitude"><br><br>
Longitude:<input type="text" name="hospital_longitude"><br><br>
Hospital Image:<input type="file" name="hospital_image1"><br><br>
<!--  Hospital Image2:<input type="file" name="hospital_image2"><br><br>
Hospital Image3:<input type="file" name="hospital_image3"><br><br>-->

<input type="submit" name = "hospital_button" value = "Register" >
</form>
</body>
</html>