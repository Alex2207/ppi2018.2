package agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seliga")
public class ProjetoEistein extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Alexsandro Magno Martins da Silva</h1>");
		out.println("<h1>07alex.***@gmail.com</h1>");
		out.println("<h1>22 de julho de 2000</h1>");
		out.println("<body>");
		out.println("</html>");
	}

}
