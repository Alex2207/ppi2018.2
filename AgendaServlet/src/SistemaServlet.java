import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.models.Contato;

public class SistemaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		ServletRequest request;
		String acao = request.getParameter("logica");
		ContatoDao dao = new ContatoDao();
		
		if (acao.equals("AdicionaContato")) {
			Contato contato = new Contato();
		}
	}
	
}
