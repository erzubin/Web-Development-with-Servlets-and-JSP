package quotations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/quotations/QuotationController")
public class QuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuotationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
         
ServletContext context=getServletContext();
    	
		
		List<Quotation> AED=new ArrayList<Quotation>();
		String search1=request.getParameter("search1");
		String host="cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu54";
		String url ="jdbc:mysql://" + host + ":" + port + "/" +dbName;
		
		try{
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		Driver driver = new org.gjt.mm.mysql.Driver();
		Connection connection = DriverManager.getConnection(url, dbName, "2o6vax#!");
		Statement statement = connection.createStatement();
		String Query=null;
		if(request.getParameter("search")!=null)
		{
			Query="SELECT * FROM quotations where author LIKE '%" +search1+"%' OR text LIKE '%" +search1+"%' ";
		}
		if(request.getParameter("search")==null)
		{
		 Query="SELECT * FROM quotations ";
		}
		System.out.println("hii");
		ResultSet resultset=statement.executeQuery(Query);
		
		
		while(resultset.next())
		{
			int id = resultset.getInt("id");
			
			String author = resultset.getString("author");
			
			String text=resultset.getString("text");
		    
			AED.add(new Quotation(id,author,text));
		}
		
		request.setAttribute("AEDlist", AED);
		context.setAttribute("AEDlist", AED);
		connection.close();
		
		request.getRequestDispatcher("/WEB-INF/QuotationView.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
