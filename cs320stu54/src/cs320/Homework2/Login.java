package cs320.Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import com.sun.net.httpserver.HttpServer;






@WebServlet(urlPatterns="/Homework2/Login" )
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String error="";
   
    public Login() {
        super();
    }

	
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		List<CS320User> user = new ArrayList<CS320User>();
		
		if(context.getAttribute("HomeworkUsers")==null)
		{
			user.add(new CS320User("John" , "Doe" , "john@doe.com", "1!"));
			user.add(new CS320User("Joe" , "Boxer" , "joe@boxer.com", "2@"));
			
			context.setAttribute("HomeworkUsers", user);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registration Form</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
	    out.println("<form action='Login' method='post'>");
	    out.println("Username:<input type='text' name='name' ></br>");
	    out.println("Password:<input  type='password' name='pass'></br>");
	   
	   
	    out.println("<input type='checkbox' name='my_field' value='someValue'>Remember me<br>");
	   
	    out.println(error);
	    out.println("<input type='submit' value='Login'>");
	    out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context = getServletContext();
		List<CS320User> user=(List<CS320User>) context.getAttribute("HomeworkUsers");
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
	boolean formposted=false;
		boolean isActive = (request.getParameterValues("my_field") != null);
		
		
		for(CS320User w:user)
		{
			if(username.equals(w.getEmail()) && password.equals(w.getPassword()))
			{
				HttpSession session = request.getSession();
						session.setAttribute( "CurrentUser", w );
						
				
				if(isActive)
				{
					MessageDigest digest;
					String s="";
					try {
						
						digest = MessageDigest.getInstance("SHA-256");
						byte[] hash = digest.digest(username.getBytes("UTF-8"));
						
						 s = DatatypeConverter.printHexBinary(hash);
						
					
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					 Cookie cookie = new Cookie( "Homework2", s );
					 response.addCookie(cookie);
				}
						
					
				
						response.sendRedirect("Welcome"); 

				
			}
			
		}
		 error =  "<p style=\"color: red;\">Invalid Username	and/or	Password</p>";
			//RequestDispatcher dd = request.getRequestDispatcher("Login");
			doGet(request,response);
			
	}

}
