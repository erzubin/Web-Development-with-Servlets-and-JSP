package cs320.Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.catalina.startup.HomesUserDatabase;


@WebServlet(urlPatterns="/Homework2/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Welcome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 if( request.getSession().getAttribute( "CurrentUser" ) == null )
	        {ServletContext context = getServletContext();
			 List<CS320User> user=(List<CS320User>) context.getAttribute("HomeworkUsers");
			 
	        Cookie cookie[]=request.getCookies();
			 
	        if(cookie!=null)
	        {
	        	for(Cookie cook : cookie)
			 {
				 if(cook.getName().equals("Homework2"))
				 {
					 for(CS320User users:user)
					 {
						 MessageDigest digest;
							String s="";
							try {
								
								digest = MessageDigest.getInstance("SHA-256");
								byte[] hash = digest.digest(users.getEmail().getBytes("UTF-8"));
								
								 s = DatatypeConverter.printHexBinary(hash);
								
							    if(s.equals(cook.getValue()))
							    		{
							    	 request.getSession().setAttribute( "CurrentUser",users ); 
							    		
							    		}
							} catch (NoSuchAlgorithmException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
					 }
				 }
			 }
			 
	        }}
		 if( request.getSession().getAttribute( "CurrentUser" ) == null)
		 {
			 response.sendRedirect( "Login" );
	            return;
		 }
		 
		 	CS320User cur_user = (CS320User) request.getSession().getAttribute("CurrentUser");
	        // if the user is logged in, display the members-only content
	        response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        out.println( "<html>" );
	        out.println( "<head><title></title></head>" );
	        out.println( "<body>" );
	        out.println( "<h1>Welcome "+cur_user.getFirst() + cur_user.getLast()+"</h1>" );
	       
	        out.println( "</body></html>" );
		 
	    }
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		  doGet( request, response );
	}

}
