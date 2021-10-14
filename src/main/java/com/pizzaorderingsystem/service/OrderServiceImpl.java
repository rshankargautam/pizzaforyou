package com.pizzaorderingsystem.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizzaorderingsystem.dao.OrderDao;
import com.pizzaorderingsystem.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public void addOrder(Order o) throws SQLException {
		orderDao.addOrder(o);
	}

	public List<Order> seeAllOrder() throws SQLException {
		return orderDao.seeAllOrder();	
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
