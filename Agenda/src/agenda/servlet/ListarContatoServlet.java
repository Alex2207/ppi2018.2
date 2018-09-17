package agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.daos.ContatoDAO;
import agenda.models.Contato;
@WebServlet("/listaContatos")
public class ListarContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> lista = dao.getLista();
		
		request.setAttribute("Contatos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListaExercicio.jsp");
		rd.forward(request, response);
	}
	
}
