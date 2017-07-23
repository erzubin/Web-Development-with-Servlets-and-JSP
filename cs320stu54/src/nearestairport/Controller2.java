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

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/nearestairport/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final double R = 6372.8; // In kilometers
    public Controller2() {
        super();
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		request.getRequestDispatcher("/WEB-INF/Controller2.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cityzip =request.getParameter("search1");
		int distance =Integer.parseInt(request.getParameter("search2"));
		List<airportBean> AED1=new ArrayList<airportBean>();
		ServletContext context=getServletContext();
		
		
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
			Query="SELECT * FROM zipcodes where zip='" +cityzip+"'";
		}
		if(request.getParameter("search")==null)
		{
			System.out.println("pls enter value");
		}
		
		ResultSet resultset=statement.executeQuery(Query);
		double lon11=0.00;
		double lat12=0.00;
		while(resultset.next())
		{
			lon11 = resultset.getDouble("longitude");
			
		    lat12 = resultset.getDouble("latitude");
			
		
		}
		
		String Query1="SELECT * FROM Airports";
		
		ResultSet resultset1=statement.executeQuery(Query1);
		double lon21=0.00;
		double lat22=0.00;
		String nameAP="";
		while(resultset1.next())
		{
			
			
			lon21 = resultset1.getDouble("Longitude");
			
		    lat22 = resultset1.getDouble("Latitude");
			
		    nameAP =resultset1.getString("Airport");
		
		    
		       
		      
		       double dis= haversine(lat12, lon11, lat22, lon21);
		       
		       if(dis<=distance)
		       {
		    	   AED1.add(new airportBean(nameAP,lat22 ,lon21));
		       }
		        
		    
		}
		
		request.setAttribute("AEDlist1", AED1);
		
		connection.close();
		
		request.getRequestDispatcher("/WEB-INF/Controller2.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			
		}
	
	
	}

}
