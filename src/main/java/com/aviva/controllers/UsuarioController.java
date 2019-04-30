package com.aviva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aviva.model.Usuario;
import com.aviva.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository ur;
	
	private String recebeLogin;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value ="/", method = RequestMethod.POST)
	public String login(Usuario usuario) {
		
		if(ur.findByLogin(usuario.getLogin()) != null ) { 
				if(ur.findByLogin(usuario.getLogin()).getSenha().equals(usuario.getSenha())) {
					recebeLogin = usuario.getLogin();
		
				if(ur.findByLogin(usuario.getLogin()).getCargo().equals("Adm")){
					
					return "redirect:/loginAdm";
				}else {
					
					return "redirect:/loginComum";
				}
			}else {
				
				return "redirect:/index";
			}
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value="/loginAdm", method=RequestMethod.GET)
	public ModelAndView loginAdm() {
		Usuario usuario = ur.findByLogin(recebeLogin);
		ModelAndView mav = new ModelAndView("login/loginAdm");
		mav.addObject("usuario", usuario);
		return mav;
	}
	
	@RequestMapping(value="/loginComum", method=RequestMethod.GET)
	public ModelAndView loginComum() {
		Usuario usuario = ur.findByLogin(recebeLogin);
		ModelAndView mav = new ModelAndView("login/loginComum");
		mav.addObject("usuario", usuario);
		return mav;
	}
	
	@RequestMapping(value="/esqueceusenha", method=RequestMethod.GET)
	public String esqueceu() {
		return "esqueceusenha";
	}
	
}
