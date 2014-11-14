package br.com.lopes.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutenticacaoController {
	
	private Logger logger = Logger.getLogger(IndexController.class);
	
	
	@RequestMapping(value="/logon",method=RequestMethod.POST)
	public ModelAndView logon(@RequestParam String usuario,
							  @RequestParam String senha,
							  HttpSession session){
		
		session.setAttribute("username", usuario);
		
		logger.info("Logon de "+usuario+"/"+senha);
		
		ModelAndView resultado = new ModelAndView("pagina");
		return resultado;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("username");
		session.invalidate();
		
		return "redirect:/";
		
	}

}
