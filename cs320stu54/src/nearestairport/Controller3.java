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


@WebServlet("/nearestairport/Controller3")
public class Controller3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Controller3() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/Controller3.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String city = request.getParameter("city_name");
		int dis = Integer.parseInt(request.getParameter("distance"));
		String search=request.getParameter("search");
		
		ServletContext context=getServletContext();
		
		List<cityBean> AED=new ArrayList<cityBean>();
		
		List<airportBean> AED1=new ArrayList<airportBean>();
		
		
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
		String Query1 = null;
		
		if(search!=null)
		{
			Query="SELECT * FROM zipcodes where city='"+city+"'";
			
			Query1="SELECT * FROM Airports";
		}
		if(search==null)
		{
			request.getRequestDispatcher("/WEB-INF/Controller3.jsp").forward(request, response);
		}
		
		ResultSet resultset=statement.executeQuery(Query);
		
		
		while(resultset.next())
		{
			int zip = resultset.getInt("zip");
			
			String city1 = resultset.getString("city");
			
		double longitude1 = resultset.getDouble("longitude");
		
		double latitude1= resultset.getDouble("latitude");
		
		ResultSet resultset1=statement.executeQuery(Query1);
		
		while(resultset1.next())
		{
			
		}
			AED.add(new cityBean(zip,city,longitude1,latitude1));
		}
		

		}
		catch(Exception e)
		{
			
		}
	}

}
