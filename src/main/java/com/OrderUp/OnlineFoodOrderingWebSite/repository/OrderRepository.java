package com.OrderUp.OnlineFoodOrderingWebSite.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OrderUp.OnlineFoodOrderingWebSite.Model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {
//	@Query("SELECT o FROM Order1 o WHERE o.customer.id = :userId")
//	List<Order1> findAllUserOrders(@Param("userId")Long userId);
//    
//	@Query("SELECT o FROM Order1 o WHERE o.restaurant.id = :restaurantId")
//	List<Order1> findOrdersByRestaurantId(@Param("restaurantId") Long restaurantId);
}
