package com.jacaranda.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jacaranda.calculadora.model.Calculadora;

@Controller
public class MainController {

	@GetMapping("/")
	public String calculadora(Model model) {
		
		Calculadora calculadora = new Calculadora();
		model.addAttribute("calculadora", calculadora);
		
		
		return "index";
	}
	
	
	@GetMapping("/resolver")
	public String resolver(@Validated Model model, @ModelAttribute("calculadora") Calculadora calculadoraUser, 
			BindingResult bindingResult) {
		
		String redirect = "index";
		
		Calculadora calculadora = new Calculadora(calculadoraUser.getNum1(), calculadoraUser.getOperador(), calculadoraUser.getNum2());
		model.addAttribute("calculadora", calculadora);
		
		String operador = "";
		
		if (calculadoraUser.getOperador() == 1) {
			operador = "+";
		
		}else if (calculadoraUser.getOperador() == 2) {
			operador = "-";
		}
		
		
		if (bindingResult.hasErrors()) {
			redirect = "index";
		
		}else {	
			String resultado = calculadoraUser.getNum1() 
					+ operador + calculadoraUser.getNum2() 
					+ " = " + calculadoraUser.operar();
			
			model.addAttribute("resultado", resultado);
		}
		
				
		return redirect;
	}
	
	
	
	/*@GetMapping("/saludo/{name}")
	public String saludo(Model model, @PathVariable String name) {
		//Hay que pasarle un nombre o una cadena como
		//si fuera una ruta (como en JavaScript en peticiones)
		model.addAttribute(name, name);
		return "index";
	}*/
	
	
	/*@GetMapping({"/addUser", "/user/addUser"})
	public String addUser() {
		return "user/addUser";
	}*/
}
