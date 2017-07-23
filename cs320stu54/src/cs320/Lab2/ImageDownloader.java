package cs320.Lab2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ImageDowloader
 */
@WebServlet("/Lab2/ImageDownloader")
public class ImageDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDownloader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 ServletContext context = getServletContext();
	 if ( request.getParameter("image") != null){
			
			String filename = request.getParameter("image") + ".png";
			String path = getServletContext().getRealPath("/image/"+filename);
			System.out.println("PATH = " + path);
	
		        // reads input file from an absolute path
		       
		        java.io.File downloadFile = new File(path);
		        FileInputStream inStream = new FileInputStream(downloadFile);
		         
		        // if you want to use a relative path to context root:
		        String relativePath = getServletContext().getRealPath("");
		        System.out.println("relativePath = " + relativePath);
		         
		        // obtains ServletContext
		        ServletContext c = getServletContext();
		         
		        // gets MIME type of the file
		        String mimeType = context.getMimeType(path);
		        if (mimeType == null) {        
		            // set to binary type if MIME mapping <a href="#" id="_GPLITA_6" in_rurl="http://s.ltmmty.com/click?v=VVM6ODc1NjY6MzI4NTpub3QgZm91bmQ6MzJiYmJhN2MzNTE1ZTc1ODU1ZDRmYzFhYzlhZDc1OGE6ei0xNTExLTIxMDkwNTg6d3d3LmNvZGVqYXZhLm5ldDoyNTc5OTg6NmEwMjI4YTE5Y2Y4NjVlNjBhZjMzZTg2YzZjYTNhYmI6MjZiYjY3YWY5NDhiNGJlNThjNDMyMmE0ZjU2MDcxNjY6MTpkYXRhX3NzLDcyOHgxMzY2O2RhdGFfZmIsbm87ZGF0YV9pdG5fdGVzdCwyMDE1MDQzMF9jOzo2ODIwMzU1&subid=g-2109058-91a06c7d402a46ab87b58a78a0fbd2ae-&data_ss=728x1366&data_fb=no&data_itn_test=20150430_c&data_tagname=PRE" title="Click to Continue > by IntelliTerm" style="border: none !important; display: inline-block !important; text-indent: 0px !important; float: none !important; font-weight: bold !important; height: auto !important; margin: 0px !important; min-height: 0px !important; min-width: 0px !important; padding: 0px !important; text-transform: uppercase !important; text-decoration: underline !important; vertical-align: baseline !important; width: auto !important; background: transparent !important;">not found<img src="http://cdncache-a.akamaihd.net/items/it/img/arrow-10x10.png" style="border: none !important; display: inline-block !important; text-indent: 0px !important; float: none !important; font-weight: bold !important; height: 10px !important; margin: 0px 0px 0px 3px !important; min-height: 0px !important; min-width: 0px !important; padding: 0px !important; text-transform: uppercase !important; text-decoration: underline !important; vertical-align: super !important; width: 10px !important; background: transparent !important;"></a>
		            mimeType = "application/octet-stream";
		        }
		        System.out.println("MIME type: " + mimeType);
		         
		        // modifies response
		        response.setContentType(mimeType);
		        response.setContentLength((int) downloadFile.length());
		         
		        // forces download
		        String headerKey = "Content-Disposition";
		        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		        response.setHeader(headerKey, headerValue);
		         
		        // obtains response's output stream
		        OutputStream outStream = response.getOutputStream();
		         
		        byte[] buffer = new byte[4096];
		        int bytesRead = -1;
		         
		        while ((bytesRead = inStream.read(buffer)) != -1) {
		            outStream.write(buffer, 0, bytesRead);
		        }
		         
		        inStream.close();
		        outStream.close();     
	 }
	 
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ImageDownloader</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Image Downloader</h3>");
		out.println("<div><a href='ImageDownloader?image=bean'>bean</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=clint'>clint</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=gaga'>gaga</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=hermoine'>hermoine</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=joker'>joker</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=mj'>mj</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=penny'>penny</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=sheldon'>sheldon</a></div>");
		out.println("<br/>");
		out.println("<div><a href='ImageDownloader?image=steve'>steve</a></div>");
		out.println("<br/>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
