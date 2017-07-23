<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>QuatationView</title>
</head>
<body>
<a href="AddQuotationController">Add Comment</a>

<form action="QuotationController" method ="get">
	<input type="text" name="search1"/>
	<input type="submit" value="search" name="search"/>
</form>

<table border="1">
<tr>
<th>Id</th><th>Author</th><th>Quotation</th>
</tr>
<c:forEach items="${AEDlist}" var="en">
<tr>
<td>${en.id}</td>
<td>${en.author}</td>
<td>${en.text}</td>
<td><a href="EditQuotationController?id=${en.id}">Edit</a></td>
<td><a href="DeleteQuotationController?id=${en.id}">Delete</a></td>
</tr>
</c:forEach>
</table>


</body>
</html>