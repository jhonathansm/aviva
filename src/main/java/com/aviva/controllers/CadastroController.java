package com.aviva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aviva.model.Usuario;
import com.aviva.model.cadastrarVisitantes;
import com.aviva.repository.UsuarioRepository;
import com.aviva.repository.VisitantesRepository;

@Controller
public class CadastroController {

	
	@Autowired
	VisitantesRepository vr;
	@Autowired
	UsuarioRepository ur;
	
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public String cadastro() {
		return "cadastro/cadastro";
	}
	
	@RequestMapping(value="/cadastro", method = RequestMethod.POST)
	public String cadastro(Usuario usuario, RedirectAttributes attributes) {
		ur.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
		return "redirect:/cadastro";
	}
	
	
	
	@RequestMapping(value="/cadastroVisitantes", method=RequestMethod.GET)
	public String Visitante() {
		return "cadastro/cadastrarVisitantes";
	}
	
	@RequestMapping(value="/cadastroVisitantes", method=RequestMethod.POST)
	public String cadastrar(cadastrarVisitantes visitante, RedirectAttributes attributes) {
			vr.save(visitante);
			attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
			return "redirect:/cadastroVisitantes";
		
	}
	
	@RequestMapping(value="/cadastroAdm", method = RequestMethod.POST)
	public String cadastroAdm(Usuario usuario, RedirectAttributes attributes) {
		ur.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
		return "redirect:/cadastroAdm";
	}
	
	@RequestMapping(value="/cadastroAdm", method=RequestMethod.GET)
	public String cadastroDm() {
		return "cadastro/cadastroAdm";
	}
	
	
}
