package nearestairport;

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

import quotations.Quotation;


@WebServlet("/nearestairport/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context=getServletContext();
		List<cityBean> AED=new ArrayList<cityBean>();
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
			Query="SELECT * FROM zipcodes where city='" +search1+"'";
		}
		if(request.getParameter("search")==null)
		{
			request.getRequestDispatcher("/WEB-INF/Controller.jsp").forward(request, response);
		}
		
		ResultSet resultset=statement.executeQuery(Query);
		
		
		while(resultset.next())
		{
			int zip = resultset.getInt("zip");
			
			String city = resultset.getString("city");
			
		double longitude = resultset.getDouble("longitude");
		
		double latitude= resultset.getDouble("latitude");
		    
			AED.add(new cityBean(zip,city,longitude,latitude));
		}
		
		request.setAttribute("AEDlist", AED);
		context.setAttribute("AEDlist", AED);
		connection.close();
		
		request.getRequestDispatcher("/WEB-INF/Controller.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
