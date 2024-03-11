package com.OrderUp.OnlineFoodOrderingWebSite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.OrderUp.OnlineFoodOrderingWebSite.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
