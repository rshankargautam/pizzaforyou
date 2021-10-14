package com.pizzaorderingsystem.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Toppings;
import com.pizzaorderingsystem.service.PizzaToppingService;

@Controller
public class HomeController {
	
	@Autowired
	private PizzaToppingService pizzaToppingService;
	
	public PizzaToppingService getPizzaToppingService() {
		return pizzaToppingService;
	}
	public void setPizzaToppingService(PizzaToppingService pizzaToppingService) {
		this.pizzaToppingService = pizzaToppingService;
	}
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	@RequestMapping("/admin")
	public String admin() {
		
		return "admin";
	}
	@RequestMapping("/user")
	public ModelAndView user() throws SQLException {
		ModelAndView mv = new ModelAndView();
			List<Pizza> listPizza = pizzaToppingService.listPizza();
			List<Toppings> listTopping = pizzaToppingService.listToppings();
			mv.addObject("pizza",listPizza);
			mv.addObject("topping",listTopping);
			
		return mv;
	}
	
}
