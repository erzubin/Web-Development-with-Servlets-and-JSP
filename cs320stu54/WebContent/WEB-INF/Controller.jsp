<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>cities zip code</title>
</head>
<body>

<a href="../nearestairport/Controller2">Find the nearest airport within your desired distance WITH THE SPECIFIC ZIPCODE  !!!</a><br />
<a href="../nearestairport/Controller3">Find the nearest airport within your desired distance WITH THE CITY NAME !!!</a><br />

<form action="Controller" method ="get">
	Enter Name of the City:<input type="text" name="search1"/><br />
	<input type="submit" value="search" name="search"/><br />
</form>

<table border="1">
<tr>
<th>Zip</th><th>City</th><th>Map view</th>
</tr>
<c:forEach items="${AEDlist}" var="en">
<tr>
<td>${en.zip}</td>
<td>${en.city}</td>
<td><img alt="Map" src="https://maps.googleapis.com/maps/api/staticmap?zoom=13&size=600x300&maptype=roadmap
&markers=color:blue%7Clabel:S%7C${en.latitude} ,${en.longitude}"></img></td>

</tr>
</c:forEach>
</table>

</body>
</html>