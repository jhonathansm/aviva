package com.aviva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.aviva.model.cadastrarVisitantes;
import com.aviva.repository.VisitantesRepository;

@Controller
public class CadastroController {

	
	@Autowired
	VisitantesRepository vr;
	
	
	
	@RequestMapping(value="/cadastroVisitantes", method=RequestMethod.GET)
	public String Visitante() {
		return "cadastro/cadastrarVisitantes";
	}
	
	@RequestMapping(value="/cadastroVisitantes", method=RequestMethod.POST)
	public String cadastrar(cadastrarVisitantes visitante) {
			vr.save(visitante);

			return "redirect:/cadastroVisitantes";
		
		
	}
	
	
	
}
