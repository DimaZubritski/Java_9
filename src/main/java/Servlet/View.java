package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Boolean d = false;
		pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
				+ "	<title>website!</title>\r\n"
				+ "</head>\r\n"
				+ "<frameset rows=\"*,60\">\r\n"
				+ "	<frame name=\"messages\" src=\"messages.do\">\r\n"
				+ "	<frame name=\"message\" src=\"/mychat/compose_message.do\">\r\n"
				+ "	<noframes>\r\n"
				+ "		<body>\r\n"
				+ "		<p>.</p>\r\n"
				+ "		</body>\r\n"
				+ "	</noframes>\r\n"
				+ "</frameset>\r\n"
				+ "</html>");
		if(d) {
			response.sendRedirect(response.encodeRedirectURL("/mychat/"));
		}
		
		d = true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
