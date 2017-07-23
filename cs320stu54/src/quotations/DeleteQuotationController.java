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


@WebServlet("/quotations/DeleteQuotationController")
public class DeleteQuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteQuotationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		int id = Integer.parseInt(request.getParameter("id"));
		
		String host="cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu54";
		String url ="jdbc:mysql://" + host + ":" + port + "/" +dbName;
		
		try{
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		Driver driver = new org.gjt.mm.mysql.Driver();
		Connection connection = DriverManager.getConnection(url, dbName, "2o6vax#!");
		Statement statement = connection.createStatement();
		String Query="DELETE FROM quotations where id= '" +id+ "'";
		System.out.println(Query);
		int resultset = statement.executeUpdate(Query);
		
		connection.close();
		
		response.sendRedirect("../quotations/QuotationController");
		
		} 
		catch (Exception e) {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
