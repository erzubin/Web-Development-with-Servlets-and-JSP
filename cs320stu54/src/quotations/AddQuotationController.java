package quotations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/quotations/AddQuotationController")
public class AddQuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddQuotationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/AddQuotationView.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  
        String author = request.getParameter("author");
        String text = request.getParameter("text");
        if(author.equals("null") || text.equals("null") || author.equals("") || text.equals(""))
        {
        	System.out.println("die");
        	request.getRequestDispatcher("/WEB-INF/AddQuotationView.jsp").forward(request, response);
        }
        
        String host="cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu54";
		String url ="jdbc:mysql://" + host + ":" + port + "/" +dbName;
		

		try{
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		Driver driver = new org.gjt.mm.mysql.Driver();
		Connection connection = DriverManager.getConnection(url, dbName, "2o6vax#!");
		Statement statement = connection.createStatement();
		String Query= "INSERT INTO cs320stu54.quotations(author, text) VALUES('" +author+ "' , '" +text + "');";
		statement.executeUpdate(Query);
		
		
		connection.close();
		response.sendRedirect("../quotations/QuotationController");
		
		} 
		catch (Exception e) {
			
		}
	}

}
