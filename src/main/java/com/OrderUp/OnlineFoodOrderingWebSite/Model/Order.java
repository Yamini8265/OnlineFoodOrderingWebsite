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

@Data
@Entity
public class Order {
	
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
	private List<OrderItems> orderItems;
	
//	private Payment payment;
	
	private int totalItems;
	
	private int totalPrice;
	
	
	

}
