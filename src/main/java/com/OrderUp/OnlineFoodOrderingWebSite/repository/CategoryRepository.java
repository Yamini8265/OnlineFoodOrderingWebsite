package com.OrderUp.OnlineFoodOrderingWebSite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OrderUp.OnlineFoodOrderingWebSite.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//	public List<Category> findByRestaurantId(Long id);
}
