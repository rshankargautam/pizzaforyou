package com.pizzaorderingsystem.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizzaorderingsystem.model.Order;
import com.pizzaorderingsystem.service.OrderService;
import com.pizzaorderingsystem.service.OrderServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@RequestMapping(path="/orderstatus", method = RequestMethod.POST)
	public String payBill(@Valid @ModelAttribute("order") Order order, BindingResult result) {
			if(result.hasErrors()) {
				return "user";
			}else {
				try {
					orderService.addOrder(order);
				} catch (SQLException e) {			
					e.printStackTrace();
				}
			return "orderstatus";
			}
	}
	
}

