package cs320.Homework1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Homework1/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String nameerror = "";
	String emailerror = "";
	String password1error = "";
	String password2error = "";
	
	boolean formPosted=false;
    public Register() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		String fullname = "";
		String mail = "";
		String pass1 = "";
		String pass2 = "";
		//boolean formPosted = false;
		
		if(formPosted){
			
			 fullname = request.getParameter("name");
			 mail = request.getParameter("email");
			 pass1 = request.getParameter("password1");
			 pass2 = request.getParameter("password2");
			 
		}else {
			 nameerror = "";
			 emailerror = "";
			 password1error = "";
			 password2error = "";
		}
		formPosted = false;
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>REGISTRATION FORM</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>REGISTRATION <small>FORM</small></h1>");
		out.println("	</div>");
	   
		out.println("<form action=\"Register\" method=\"post\">");
		
		out.println("Name <br><input type=\"text\" name=\"name\" value=\""+fullname+ "\"><br />");
		out.println(nameerror);
		
		
		out.println("E-mail Address <br><input type=\"text\" name=\"email\" value=\""+mail+ "\" ><br />");
		out.println(emailerror);
		
	    out.println("Password <br><input type=\"password\" name=\"password1\" value=\""+pass1+ "\"><br />");
	    out.println(password1error);
	    
	    out.println("Re-Enter Password <br><input type=\"password\" name=\"password2\" value=\""+pass2+ "\"><br />");
	    out.println(password2error);
	   
	    out.println("<input type=\"submit\"  name=\"submit\" value=\"Register\">");
       
	    out.println("	</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		boolean displayForm=false;
		formPosted=true;
		
		String vaild_email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String vaild_password = "((?=.*\\d)(?=.*[@#$%!]).{2,40})";
		
		
		String fullname = request.getParameter("name");
		String mail = request.getParameter("email");
		String pass1 = request.getParameter("password1");
		String pass2= request.getParameter("password2");
		String[] arr= fullname.split("\\s");
		String fname="";
		if(formPosted)
		{
			nameerror="";
			emailerror="";
			password1error="";
			password2error="";
		}
		String lname="arr[arr.length-1]";
		for (int i = 0; i <= arr.length-2; i++) {
			//System.out.println(arr[i]);
			fname = fname +" "+ arr[i];
		}
		
		if (fullname == null || fullname == "") {
			displayForm = true;
			 nameerror =  "<p style=\"color: red;\">Name is required.</p>";
		}else if (arr.length<2) {
			displayForm = true;
			 nameerror =  "<p style=\"color: red;\">Enter valid Name.</p>";
		System.out.println(nameerror);
		}
		
		if (mail == null || mail =="") {
			displayForm = true;
			 emailerror =  "<p style=\"color: red;\">Email Address is required.</p>";
		} else if(!mail.matches(vaild_email)){
			displayForm = true;
			 emailerror =  "<p style=\"color: red;\">Enter valid Email Address.</p>";
		}
		
		if (pass1 == null || pass1 == "") {
			displayForm = true;
			 password1error =  "<p style=\"color: red;\">Password is required.</p>";
		} else if(!pass1.matches(vaild_password)){
			displayForm = true;
			 password1error =  "<p style=\"color: red;\">Please use atleast one degit and special symbol in password.</p>";
		}
		
		if (pass2 == null || pass2 =="") {
			displayForm = true;
			 password2error =  "<p style=\"color: red;\">Re-Enter password is required.</p>";
		} else if (!pass2.equals(pass1)) {
			displayForm = true;
			 password2error =  "<p style=\"color: red;\">Password and Re-Enter password not match.</p>";
		}
		
		PrintWriter out = response.getWriter();
		if (!displayForm) {
			
			out.println("<!doctype html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Registration Form</title>");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Welcome, "+ fname + "</h3>");
			out.println("<div><a href='../Homework2/Login'>Login</a></div>");
			out.println("</body>");
			out.println("</html>");
					
		} else {
			
			doGet(request, response);
		}
	}
}
