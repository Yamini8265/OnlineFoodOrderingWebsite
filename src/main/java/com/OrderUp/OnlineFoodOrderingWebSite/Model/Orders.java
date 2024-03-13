package com.OrderUp.OnlineFoodOrderingWebSite.Model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private User Customer;
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	private Long totalAmount;
	
	private String OrderStatus;
	
	private Date createdOn;
	
	@ManyToOne
	private Address deliveryAddress;
	
	
	@OneToMany
	private List<OrderItem> orderItems;
	
//	private Payment payment;
	
	private int totalItems;
	
	private int totalPrice;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(long id, User customer, Restaurant restaurant, Long totalAmount, String orderStatus, Date createdOn,
			Address deliveryAddress, List<OrderItem> orderItems, int totalItems, int totalPrice) {
		super();
		this.id = id;
		Customer = customer;
		this.restaurant = restaurant;
		this.totalAmount = totalAmount;
		OrderStatus = orderStatus;
		this.createdOn = createdOn;
		this.deliveryAddress = deliveryAddress;
		this.orderItems = orderItems;
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getCustomer() {
		return Customer;
	}

	public void setCustomer(User customer) {
		Customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}
