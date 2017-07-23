package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet("/midterm/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public add() {
        super();
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
	    out.println("<form action='add' method='post'>");
	    out.println("Name:<input type='text' name='Name' ></br>");
	    out.println("Description:<input type='text' name='Description' ></br>");
	    out.println("Price:<input type='text' name='Price' ></br>");
	    out.println("Quantity:<input type='text' name='Inventory' ></br>");
	    
	    out.println("<input type='submit' value='add'>");
	    out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context = getServletContext(); 
		List<InventoryItem> InventoryItem = (List<InventoryItem>) context.getAttribute("Item");
		
		String Name = request.getParameter("Name");
		String Description = request.getParameter("Description");
		int Price =Integer.parseInt( request.getParameter("Price"));
		double Inventory = Double.parseDouble(request.getParameter("Inventory"));
		InventoryItem.add(new InventoryItem( Name, Description,Price,Inventory));
		
		response.sendRedirect("StoreAdmin");
	}
	
	
}

	
