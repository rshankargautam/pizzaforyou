package com.pizzaorderingsystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.model.Order;
import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Toppings;

@Repository
@Transactional
public class PizzaToppingDaoImpl implements PizzaToppingDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPizza(Pizza p) throws SQLException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePizza(String pizzaName) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Pizza.class);
		crit.add(Restrictions.eq("name",pizzaName));
		List<Pizza> results = crit.list();
		
		Pizza p = (Pizza) session.load(Pizza.class, results.get(0).getPizzaId());
		if(null != p){
			session.delete(p);
			System.out.println("deletion successful");
		}
	}

	public void updatePizza(Pizza p) throws SQLException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria crit = session.createCriteria(Pizza.class);
			crit.add(Restrictions.eq("name",p.getName()));
			List<Pizza> results = crit.list();
			p.setPizzaId(results.get(0).getPizzaId());	
			session.merge(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTopping(Toppings t) throws SQLException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(t);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTopping(String toppingName) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Toppings.class);
		crit.add(Restrictions.eq("name",toppingName));
		List<Toppings> results = crit.list();
		
		Toppings t = (Toppings) session.load(Toppings.class, results.get(0).getId());
		if(null != t){
			session.delete(t);
		}
	}

	public void updateTopping(Toppings t) throws SQLException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria crit = session.createCriteria(Toppings.class);
			crit.add(Restrictions.eq("name",t.getName()));
			List<Toppings> results = crit.list();
			t.setId(results.get(0).getId());
			session.merge(t);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")

	public List<Pizza> listPizza() throws SQLException {
		List<Pizza> pizza = new ArrayList<Pizza>();
		try {
			Session session = sessionFactory.getCurrentSession();
			pizza = session.createQuery("from Pizza").list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pizza;
	}
	@SuppressWarnings("unchecked")

	public List<Toppings> listToppings() throws SQLException {
		List<Toppings> toppings = new ArrayList<Toppings>();
		try {
			Session session = sessionFactory.getCurrentSession();
			toppings = session.createQuery("from Toppings").list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return toppings;
	}
}
