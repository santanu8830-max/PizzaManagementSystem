package com.pizzamanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagementsystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/*
	 *  customize method
	 */
	Customer findByCustomerMobile(long customerMobile);
}
