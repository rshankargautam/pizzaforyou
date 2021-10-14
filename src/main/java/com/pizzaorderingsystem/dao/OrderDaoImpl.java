package com.pizzaorderingsystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.model.Order;
import com.sun.istack.logging.Logger;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addOrder(Order o) throws SQLException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(o);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Order> seeAllOrder() throws SQLException {
		List<Order> orders = new ArrayList<Order>();
		try {
			Session session = sessionFactory.getCurrentSession();
			orders = session.createQuery("from Order").list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	

}
