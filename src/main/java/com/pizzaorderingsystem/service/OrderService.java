package com.pizzaorderingsystem.service;

import java.sql.SQLException;
import java.util.List;

import com.pizzaorderingsystem.model.Order;

public interface OrderService {
	public void addOrder(Order o) throws SQLException; 
	public List<Order> seeAllOrder() throws SQLException;
}
