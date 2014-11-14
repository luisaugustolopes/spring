package br.com.lopes.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.lopes.dao.PessoaDAOJDBC;

@Controller
public class IndexController {

	private Logger logger = Logger.getLogger(IndexController.class);

	@Autowired
	PessoaDAOJDBC pessoaDao;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/pagina")
	public ModelAndView inicio(){
		ModelAndView resultado = new ModelAndView("pagina");
		
		Calendar calendar = Calendar.getInstance();		
		DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM);
		
		resultado.addObject("data",dateFormat.format(calendar.getTime()));
		
		return resultado;
	}
	
	@RequestMapping("/drag-and-drop")
	public ModelAndView dragAndDrop(){
		return new ModelAndView();
	}
	
}
