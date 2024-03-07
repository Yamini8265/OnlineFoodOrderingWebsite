package com.OrderUp.OnlineFoodOrderingWebSite.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity	
public class OrderItems {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Food food;
	
	private int quantity;
	
	private int totalPrice;
	
	
	private List<String> ingredients;
	
	

}
