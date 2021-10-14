package com.pizzaorderingsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.pizzaorderingsystem.model.Order;
import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Toppings;

public interface PizzaToppingDao {
	public void addPizza(Pizza p) throws SQLException;
	public void deletePizza(String pizzaName) throws SQLException;
	public void updatePizza(Pizza p) throws SQLException;
	public void addTopping(Toppings t) throws SQLException;
	public void deleteTopping(String toppingName) throws SQLException;
	public void updateTopping(Toppings t) throws SQLException;
	public List<Pizza> listPizza() throws SQLException;
	public List<Toppings> listToppings() throws SQLException;
}
