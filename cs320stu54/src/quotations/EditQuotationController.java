package quotations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/quotations/EditQuotationController")
public class EditQuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditQuotationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		ServletContext context=getServletContext();
		List<Quotation> AED= (List<Quotation>)context.getAttribute("AEDlist");
		
		int id = Integer.parseInt(request.getParameter("id"));
		Quotation w = null;
		for(int i = 0; i <AED.size(); i++) {
			if (id == AED.get(i).getId()) {
				 w = AED.get(i);
				 break;
			}
		}
		
		request.setAttribute("AEDlist", w);
		request.getRequestDispatcher("/WEB-INF/EditQuotationView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String author=request.getParameter("author");
		String text=request.getParameter("text");
		int id=Integer.parseInt(request.getParameter("id"));

		String host="cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu54";
		String url ="jdbc:mysql://" + host + ":" + port + "/" +dbName;
		
		
		try{
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		Driver driver = new org.gjt.mm.mysql.Driver();
		Connection connection = DriverManager.getConnection(url, dbName, "2o6vax#!");
		Statement statement = connection.createStatement();
		String Query="UPDATE quotations SET author='" +author +"' , text='" + text +"' where id="+id;
		
		statement.executeUpdate(Query);
		System.out.println(Query);
		
		connection.close();
		response.sendRedirect("QuotationController");
		
		
		} 
		catch (Exception e) {
			
		}
	}

	


}
