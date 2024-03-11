package com.OrderUp.OnlineFoodOrderingWebSite.service;



import java.util.List;

import com.OrderUp.OnlineFoodOrderingWebSite.Dto.RestaurantDto;
import com.OrderUp.OnlineFoodOrderingWebSite.Exception.RestaurantException;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.Restaurant;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.User;
import com.OrderUp.OnlineFoodOrderingWebSite.requests.CreateRestaurantRequest;


public interface RestaurantService {

	public Restaurant createRestaurant(CreateRestaurantRequest req,User user);

	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant)
			throws RestaurantException;

	public void deleteRestaurant(Long restaurantId) throws RestaurantException;

	public List<Restaurant>getAllRestaurant();

	public List<Restaurant>searchRestaurant(String keyword);
	
	public Restaurant findRestaurantById(Long id) throws RestaurantException;

	public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException;
	
	public RestaurantDto addToFavorites(Long restaurantId,User user) throws RestaurantException;

	public Restaurant updateRestaurantStatus(Long id)throws RestaurantException;
}
