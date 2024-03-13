package com.OrderUp.OnlineFoodOrderingWebSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderUp.OnlineFoodOrderingWebSite.Exception.RestaurantException;
import com.OrderUp.OnlineFoodOrderingWebSite.Exception.UserException;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.Restaurant;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.User;
import com.OrderUp.OnlineFoodOrderingWebSite.requests.CreateRestaurantRequest;
import com.OrderUp.OnlineFoodOrderingWebSite.response.ApiResponse;
import com.OrderUp.OnlineFoodOrderingWebSite.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class AdminRestaurantController {

	@Autowired
	private RestaurantService restaurantService;

//	@Autowired
//	private UserService userService;

	@PostMapping()
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest req, User user)
			throws UserException {

		Restaurant restaurant = restaurantService.createRestaurant(req, user);
		return ResponseEntity.ok(restaurant);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody CreateRestaurantRequest req)
			throws RestaurantException, UserException {

		Restaurant restaurant = restaurantService.updateRestaurant(id, req);
		return ResponseEntity.ok(restaurant);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteRestaurantById(@PathVariable("id") Long restaurantId
	) throws RestaurantException, UserException {


		restaurantService.deleteRestaurant(restaurantId);
		
		ApiResponse res=new ApiResponse("Restaurant Deleted with id Successfully",true);
		return ResponseEntity.ok(res);
	}



	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findRestaurantByUserId(@PathVariable Long id)
			throws RestaurantException, UserException {
		Restaurant restaurant = restaurantService.getRestaurantsByUserId(id);
		return ResponseEntity.ok(restaurant);

	}

}
