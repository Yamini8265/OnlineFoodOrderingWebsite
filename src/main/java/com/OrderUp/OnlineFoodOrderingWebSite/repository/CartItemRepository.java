package com.OrderUp.OnlineFoodOrderingWebSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OrderUp.OnlineFoodOrderingWebSite.Model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
