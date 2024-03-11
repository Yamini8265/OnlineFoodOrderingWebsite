package com.OrderUp.OnlineFoodOrderingWebSite.Model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Food {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	private Long price;
	

	@ManyToOne
	private Category foodCategory;
	
	@Column(length = 1000)
	@ElementCollection
	private List<String> images;
	
	private boolean available;
	
	@ManyToOne 
	private Restaurant restaurant;
	
	private boolean isVegetarian;
	
	private boolean isSeasonal;
	
	private List<Ingredients> item = new ArrayList<>();
	
	

}
