package agendaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import agendaspring.daos.ClienteDAO;
import agendaspring.models.Cliente;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o form de contatos");
		return "contatos/form";
	}
	
	@PostMapping
	public String adicionar(Cliente contato) {
	System.out.println(contato);
	ClienteDAO dao = new ClienteDAO();
	dao.inserir(contato);
	
	return "redirect:contatos";
	}
	
	@GetMapping
	public ModelAndView listar() {
		ClienteDAO contatoDAO = new ClienteDAO();
		List<Cliente> lista = contatoDAO.getLista();
		ModelAndView model = new ModelAndView("contatos/lista");
		model.addObject("contatos", lista);
		return model;
	}
	
	@RequestMapping("/remover")
	public String remover(Cliente contato) {
		System.out.println("Chamou método de remover!");
		ClienteDAO contatoDAO = new ClienteDAO();
		contatoDAO.remover(contato);
		
		return "redirect:../contatos";
	}
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar(Cliente contato) {
		System.out.println("Chamou método selecionar!!");
		ClienteDAO contatoDAO = new ClienteDAO();
		contato = contatoDAO.getById(contato.getId());
		
		ModelAndView model = new ModelAndView("/contatos/formAlterar");
		model.addObject("contato", contato);
		
		return model;
	}
	
	@PostMapping("/alterar")
	public String alterar(Cliente contato) {
		System.out.println("Chamou o metodo alterar!!");
		System.out.println(contato);
		
		ClienteDAO contatoDAO = new ClienteDAO();
		contatoDAO.alterar(contato);
		
		return "redirect:/contatos";
	}
}
