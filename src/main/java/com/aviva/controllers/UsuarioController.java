package com.aviva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aviva.model.Usuario;
import com.aviva.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository ur;
	
	private String recebeLogin;
	
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
	
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String login(Usuario usuario) {
		if(ur.findByLogin(usuario.getLogin()) != null) {
			if(ur.findByLogin(usuario.getLogin()).getSenha().equals(usuario.getSenha())) {
				recebeLogin = usuario.getLogin();
				
				if(ur.findByLogin(usuario.getLogin()).getCargo().equals("Presbitero")) {
					return "redirect:/efetuouLoginAdm";
				}else {
					return "redirect:/efetuouLogin";
				}
			}else {
				return "redirect:/index";
			}
		}else {
			return "redirect:/index";
		}
		
	
	}
	
	@RequestMapping(value="/esqueceusenha", method=RequestMethod.GET)
	public String esqueceu() {
		return "esqueceusenha";
	}
	
}
