package com.OrderUp.OnlineFoodOrderingWebSite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OrderUp.OnlineFoodOrderingWebSite.Dto.RestaurantDto;
import com.OrderUp.OnlineFoodOrderingWebSite.Exception.RestaurantException;
import com.OrderUp.OnlineFoodOrderingWebSite.Exception.UserException;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.Restaurant;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.User;
import com.OrderUp.OnlineFoodOrderingWebSite.service.RestaurantService;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
//	private UserService userService;


	@GetMapping("/search")
	public ResponseEntity<List<Restaurant>> findRestaurantByName(
			@RequestParam String keyword) {
		List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);

		return ResponseEntity.ok(restaurant);
	}


	@GetMapping()
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {

		List<Restaurant> restaurants = restaurantService.getAllRestaurant();
		
		
		return ResponseEntity.ok(restaurants);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findRestaurantById(
			@PathVariable Long id) throws RestaurantException {

			Restaurant restaurant = restaurantService.findRestaurantById(id);
			return ResponseEntity.ok(restaurant);

	}
	

	
	


}
