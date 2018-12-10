package agendaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import agendaspring.daos.ContatoDAO;
import agendaspring.models.Contato;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o form de contatos");
		return "contatos/form";
	}
	
	@PostMapping
	public String adicionar(Contato contato) {
	System.out.println(contato);
	ContatoDAO dao = new ContatoDAO();
	dao.inserir(contato);
	
	return "redirect:contatos";
	}
	
	@GetMapping
	public ModelAndView listar() {
		ContatoDAO contatoDAO = new ContatoDAO();
		List<Contato> lista = contatoDAO.getLista();
		ModelAndView model = new ModelAndView("contatos/lista");
		model.addObject("contatos", lista);
		return model;
	}
	
	@RequestMapping("/remover")
	public String remover(Contato contato) {
		System.out.println("Chamou método de remover!");
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.remover(contato);
		
		return "redirect:../contatos";
	}
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar(Contato contato) {
		System.out.println("Chamou método selecionar!!");
		ContatoDAO contatoDAO = new ContatoDAO();
		contato = contatoDAO.getById(contato.getId());
		
		ModelAndView model = new ModelAndView("/contatos/formAlterar");
		model.addObject("contato", contato);
		
		return model;
	}
	
	@PostMapping("/alterar")
	public String alterar(Contato contato) {
		System.out.println("Chamou o metodo alterar!!");
		System.out.println(contato);
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.alterar(contato);
		
		return "redirect:/contatos";
	}
}
