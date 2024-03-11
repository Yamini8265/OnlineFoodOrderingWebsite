package com.OrderUp.OnlineFoodOrderingWebSite.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderUp.OnlineFoodOrderingWebSite.Dto.RestaurantDto;
import com.OrderUp.OnlineFoodOrderingWebSite.Exception.RestaurantException;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.Address;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.Restaurant;
import com.OrderUp.OnlineFoodOrderingWebSite.Model.User;
import com.OrderUp.OnlineFoodOrderingWebSite.repository.AddressRepository;
import com.OrderUp.OnlineFoodOrderingWebSite.repository.RestaurantRepository;
import com.OrderUp.OnlineFoodOrderingWebSite.requests.CreateRestaurantRequest;

@Service
public class RestaurantServiceImplementation implements RestaurantService {
	
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
		Address address=new Address();
		address.setCity(req.getAddress().getCity());
		address.setCountry(req.getAddress().getCountry());
		address.setFullName(req.getAddress().getFullName());
		address.setPostalCode(req.getAddress().getPostalCode());
		address.setState(req.getAddress().getState());
		address.setStreetAddress(req.getAddress().getStreetAddress());
		Address savedAddress = addressRepository.save(address);
		
		Restaurant restaurant = new Restaurant();
		
		restaurant.setAddress(savedAddress);
		restaurant.setContactInformation(req.getContactInformation());
		restaurant.setCuisineType(req.getCuisineType());
		restaurant.setDescription(req.getDescription());
		restaurant.setImages(req.getImages());
		restaurant.setName(req.getName());
		restaurant.setOpeningHours(req.getOpeningHours());
		restaurant.setRegistrationDate(req.getRegistrationDate());
		restaurant.setOwner(user);
		Restaurant savedRestaurant = restaurantRepository.save(restaurant);

		return savedRestaurant;
		
	}
	
	
	
	@Override
	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant)
			throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRestaurant(Long restaurantId) throws RestaurantException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> searchRestaurant(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant findRestaurantById(Long id) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDto addToFavorites(Long restaurantId, User user) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant updateRestaurantStatus(Long id) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}




}
