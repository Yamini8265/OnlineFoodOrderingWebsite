package com.OrderUp.OnlineFoodOrderingWebSite.Model;

import java.util.ArrayList;
import java.util.List;

import com.OrderUp.OnlineFoodOrderingWebSite.Dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private USER_ROLE role;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();
	
	@ElementCollection
	private List<RestaurantDto> favourites = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Address> addresses =  new ArrayList<>();
	
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public User(Long id, String fullName, String email, String password, USER_ROLE role, List<Orders> orders,
			List<RestaurantDto> favourites, List<Address> addresses) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.orders = orders;
		this.favourites = favourites;
		this.addresses = addresses;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public USER_ROLE getRole() {
		return role;
	}




	public void setRole(USER_ROLE role) {
		this.role = role;
	}




	public List<Orders> getOrders() {
		return orders;
	}




	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}




	public List<RestaurantDto> getFavourites() {
		return favourites;
	}




	public void setFavourites(List<RestaurantDto> favourites) {
		this.favourites = favourites;
	}




	public List<Address> getAddresses() {
		return addresses;
	}




	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
	
	
	
}
