package com.pizzaorderingsystem.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Toppings;
import com.pizzaorderingsystem.model.Order;
import com.pizzaorderingsystem.service.OrderService;
import com.pizzaorderingsystem.service.PizzaToppingService;

@Controller
public class AdminController {

	@Autowired
	PizzaToppingService pizzaToppingService;

	public PizzaToppingService getPizzaToppingService() {
		return pizzaToppingService;
	}

	public void setPizzaToppingService(PizzaToppingService pizzaToppingService) {
		this.pizzaToppingService = pizzaToppingService;
	}
	
	@Autowired
	OrderService orderService;
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/pizza")
	public String pizza() {

		return "pizza";
	}

	@RequestMapping(path = "/addpizza", method = RequestMethod.POST)
	public String addPizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result) {
		
		if(result.hasErrors()){ 
			
			return "error";
		}else {
			try {
				pizzaToppingService.addPizza(pizza);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "pizza";
		}
		
	}

	@RequestMapping(path = "/deletepizza", method = RequestMethod.POST)
	public String deletePizza(@ModelAttribute("pizza") Pizza pizza) {
		try {
			pizzaToppingService.deletePizza(pizza.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "pizza";
	}

	@RequestMapping(path = "/updatepizza", method = RequestMethod.POST)
	public String updatePizza(@ModelAttribute("pizza") Pizza pizza) {
		try {
			pizzaToppingService.updatePizza(pizza);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "pizza";
	}

	@RequestMapping("/topping")
	public String topping() {

		return "topping";
	}

	@RequestMapping(path = "/addtopping", method = RequestMethod.POST)
	public String addTopping(@Valid @ModelAttribute("toppings") Toppings toppings, BindingResult result) {
		if(result.hasErrors()) {
			
			return "error";
		}else {
			try {
				pizzaToppingService.addTopping(toppings);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "topping";
		}
	}

	@RequestMapping(path = "/deletetopping", method = RequestMethod.POST)
	public String deleteTopping(@ModelAttribute("toppings") Toppings toppings) {
		try {
			pizzaToppingService.deleteTopping(toppings.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "topping";
	}

	@RequestMapping(path = "/updatetopping", method = RequestMethod.POST)
	public String updateTopping(@ModelAttribute("toppings") Toppings toppings) {
		try {
			pizzaToppingService.updateTopping(toppings);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "topping";
	}

	@RequestMapping("/listpizza")
	public ModelAndView listPizza() throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Pizza> listPizza = pizzaToppingService.listPizza();
		mv.addObject("pizza", listPizza);
		mv.setViewName("admin");
		return mv;
	}


	@RequestMapping("/listtopping")
	public ModelAndView listTopping() throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Toppings> listTopping = pizzaToppingService.listToppings();
		mv.addObject("topping", listTopping);
		mv.setViewName("admin");
		return mv;
	}


	@RequestMapping("/listorder")
	public ModelAndView listOrder() throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Order> listOrder = orderService.seeAllOrder();
		mv.addObject("order", listOrder);
		mv.setViewName("admin");
		return mv;
	}
}
