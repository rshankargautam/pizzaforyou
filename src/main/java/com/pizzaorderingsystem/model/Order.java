package com.pizzaorderingsystem.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)@Table(name = "pizza_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String payeeName;
	private int billAmount;
	private String pizzaName;
	private String pizzaPrice;
	private String toppingPrice;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	
	public String getPizzaPrice() {
		return pizzaPrice;
	}
	public void setPizzaPrice(String pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	public String getToppingPrice() {
		return toppingPrice;
	}
	public void setToppingPrice(String toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
