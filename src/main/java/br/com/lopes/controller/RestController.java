package br.com.lopes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.lopes.dao.HistoriaDAOJDBC;
import br.com.lopes.model.Historia;

@Controller
@RequestMapping("/historia")
public class RestController {

	@Autowired
	HistoriaDAOJDBC historiaDAO;
	
	@RequestMapping(value = "/{numero}", method = RequestMethod.GET)
	public ModelAndView getHistoria(@PathVariable long numero){
		
		Historia historia = historiaDAO.getHistoria(numero);
		
		ModelAndView modelAndView = new ModelAndView("historia");
		modelAndView.addObject("historia",historia);
		return modelAndView;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getDefaultHistoria(){
		
		ModelAndView modelAndView = new ModelAndView("historia");
		modelAndView.addObject("numero", 0);
		return modelAndView;
	}
}
