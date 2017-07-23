<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<form action="EditQuotationController" method="post"> 
	     Author:<input type='text' name='author' value="${AEDlist.getAuthor()}"/><br/> 
	     Quotation:<input type='text' name='text' value="${AEDlist.getText()}"/><br/>
	     <input type="hidden" name="id" value="${AEDlist.getId()}"/>
	     
	     <input type='submit' value='edit'/> 
	     </form>  

</body>
</html>