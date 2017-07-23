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






@WebServlet("/midterm/StoreAdmin")
public class StoreAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StoreAdmin() {
        super();
    }
    

	public void init() throws ServletException {
		ServletContext context = getServletContext(); 
		List<InventoryItem> InventoryItem = new ArrayList<InventoryItem>();
		
		if(context.getAttribute("Item")==null)
		{
			context.setAttribute("Item", InventoryItem);
		}
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext(); 
		List<InventoryItem> InventoryItem = (List<InventoryItem>) context.getAttribute("Item");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Store Admin</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<form>");
		out.println("<input type='text' name='searchtext' >");
		out.println("<select value='searchtype'>");
		out.println("<option value='Name'>Name</option>");
		out.println("<option value='Description'>Description</option>");
		out.println("<option value='Price'>Price</option>");
		out.println("<option value='All'>All</option>");
		out.println("</select>");
		out.println("<input type='submit' value='Search'>");
		out.println("</form>");
		out.println("<table border=1>");
		out.println("<tr><th>Name</th><th>Description</th><th>Price</th><th>Inventory</th><th>Edit</th><th>Delete</th></tr>");
		
		for(int i=0 ; i<InventoryItem.size(); i++)
		{ InventoryItem w = InventoryItem.get(i);
			out.println("<tr><td>" + w.getName() +"</td><td>"+w.getDescription()+"</td><td>"+w.getPrice()+"</td><td>"+w.getInventory()+"</td><td><a href='editpage?id="+i+"' >edit</a> </td><td> <a href='Deletepage?id="+i+"' >delete</a> </td></tr>");
		}	
		
	

		out.println("</table>");
		out.println("<div><a href='/midterm/add'>Add New Item</a></div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
