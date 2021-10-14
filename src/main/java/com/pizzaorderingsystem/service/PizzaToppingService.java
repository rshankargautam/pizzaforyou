package com.pizzaorderingsystem.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Order;
import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Toppings;

public interface PizzaToppingService {
	public void addPizza(Pizza p) throws SQLException;
	public void deletePizza(String pizzaName) throws SQLException;
	public void updatePizza(Pizza p) throws SQLException;
	public void addTopping(Toppings t) throws SQLException;
	public void deleteTopping(String toppingName) throws SQLException;
	public void updateTopping(Toppings t) throws SQLException;
	public List<Pizza> listPizza() throws SQLException;
	public List<Toppings> listToppings() throws SQLException;
}
