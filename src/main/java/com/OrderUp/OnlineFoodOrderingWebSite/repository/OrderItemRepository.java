package com.OrderUp.OnlineFoodOrderingWebSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OrderUp.OnlineFoodOrderingWebSite.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
