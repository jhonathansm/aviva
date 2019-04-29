package com.aviva.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aviva.model.cadastrarVisitantes;
import com.aviva.repository.VisitantesRepository;

@Controller
public class ListaController {

	@Autowired
	VisitantesRepository vr;
	
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
	
}
	