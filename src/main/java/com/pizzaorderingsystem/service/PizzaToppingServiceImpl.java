package com.pizzaorderingsystem.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.dao.PizzaToppingDao;
import com.pizzaorderingsystem.dao.PizzaToppingDaoImpl;
import com.pizzaorderingsystem.model.Order;
import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Toppings;

@Service
public class PizzaToppingServiceImpl implements PizzaToppingService {
	@Autowired
	private PizzaToppingDao pizzaToppingDao;
	
	
	public PizzaToppingDao getPizzaToppingDao() {
		return pizzaToppingDao;
	}

	public void setPizzaToppingDao(PizzaToppingDao pizzaToppingDao) {
		this.pizzaToppingDao = pizzaToppingDao;
	}

	public void addPizza(Pizza p) throws SQLException {
		pizzaToppingDao.addPizza(p);
		
	}

	public void deletePizza(String pizzaName) throws SQLException {
		pizzaToppingDao.deletePizza(pizzaName);
		
	}

	public void updatePizza(Pizza p) throws SQLException {
		pizzaToppingDao.updatePizza(p);
		
	}

	public void addTopping(Toppings t) throws SQLException {
		pizzaToppingDao.addTopping(t);
	}

	public void deleteTopping(String toppingName) throws SQLException {
		pizzaToppingDao.deleteTopping(toppingName);
		
	}

	public void updateTopping(Toppings t) throws SQLException {
		pizzaToppingDao.updateTopping(t);
		
	}

	public List<Pizza> listPizza() throws SQLException {
		return pizzaToppingDao.listPizza();
	}

	public List<Toppings> listToppings() throws SQLException {
		return pizzaToppingDao.listToppings();
	}
}
