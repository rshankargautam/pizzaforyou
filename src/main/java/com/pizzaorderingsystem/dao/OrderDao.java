package com.pizzaorderingsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.pizzaorderingsystem.model.Order;

public interface OrderDao {
	
	public void addOrder(Order o) throws SQLException; 
	public List<Order> seeAllOrder() throws SQLException;
}
