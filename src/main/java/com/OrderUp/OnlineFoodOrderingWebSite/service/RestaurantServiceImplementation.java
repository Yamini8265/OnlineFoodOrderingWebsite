package com.OrderUp.OnlineFoodOrderingWebSite.service;


import java.util.List;
import java.util.Optional;

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
	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedReq)
			throws RestaurantException {
		Restaurant restaurant = findRestaurantById(restaurantId);
		if (restaurant.getCuisineType() != null) {
			restaurant.setCuisineType(updatedReq.getCuisineType());
		}
		if (restaurant.getDescription() != null) {
			restaurant.setDescription(updatedReq.getDescription());
		}
		return restaurantRepository.save(restaurant);
	}
	
	@Override
	public Restaurant findRestaurantById(Long restaurantId) throws RestaurantException {
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant.isPresent()) {
			return restaurant.get();
		} else {
			throw new RestaurantException("Restaurant with id " + restaurantId + "not found");
		}
	}

	@Override
	public void deleteRestaurant(Long restaurantId) throws RestaurantException {
		Restaurant restaurant = findRestaurantById(restaurantId);
		if (restaurant != null) {
			restaurantRepository.delete(restaurant);
			return;
		}
		throw new RestaurantException("Restaurant with id " + restaurantId + " Not found");

	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantRepository.findAll();
	}


	@Override
	public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException {
		Restaurant restaurants=restaurantRepository.findByOwnerId(userId);
		return restaurants;
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

	@Override
	public List<Restaurant> searchRestaurant(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}




}
