#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.hib.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@Column
	private Long total;
	@ManyToOne
	private Customer customer;
	@OneToMany
	private Set<Product> products = new HashSet<Product>();
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	

}
