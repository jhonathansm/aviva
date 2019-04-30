package com.aviva.controllers;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aviva.model.Usuario;
import com.aviva.model.cadastrarVisitantes;
import com.aviva.repository.UsuarioRepository;
import com.aviva.repository.VisitantesRepository;

@Controller
public class ListaController {

	@Autowired
	VisitantesRepository vr;
	
	@Autowired
	UsuarioRepository ur;
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public ModelAndView listagem() {
		Iterable<cadastrarVisitantes> visitantes =  vr.findAll();
		ModelAndView lista = new ModelAndView("lista/lista");
		lista.addObject("visitantes", visitantes);
		return lista;
	}
	
	@RequestMapping("/deletar")
	public String deletarVisitante(String email) {
		cadastrarVisitantes visitante = vr.findByEmail(email);
		vr.delete(visitante);
		return "redirect:/lista";
	}
	
	@RequestMapping(value="/listauser", method=RequestMethod.GET)
	public ModelAndView listaUsuarios() {
		Iterable<Usuario> usuarios = ur.findAll();
		ModelAndView lista = new ModelAndView("lista/listaUser");
		lista.addObject("usuarios", usuarios);
		return lista;
	}
	
	@RequestMapping("/deleta")
	public String deletarUsuario(String login) {
		Usuario usuario = ur.findByLogin(login);
		ur.delete(usuario);
		return "redirect:/listauser";
	}
	
	@RequestMapping("/alterar")
	public String alterarCargo(String login, String cargo) {
		Usuario usuario = ur.findByLogin(login);
		usuario.setCargo(cargo);
		return "redirect:/listauser";
	}
	
}
	