package com.pizzaorderingsystem.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Toppings implements Externalizable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int toppingId;
	private String name;
	private int price;
	
	public int getId() {
		return toppingId;
	}
	public void setId(int id) {
		this.toppingId = id;
	}
	public String getName() {
		return name;
	}
	public Toppings(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Toppings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
