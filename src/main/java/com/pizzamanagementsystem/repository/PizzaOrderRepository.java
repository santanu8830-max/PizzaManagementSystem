package com.pizzamanagementsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagementsystem.entity.PizzaOrder;
import com.pizzamanagementsystem.util.PizzaStatus;


@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Integer> {
	
	/*
	 * customize method
	 */
	public List<PizzaOrder> findByStatus(PizzaStatus status);
	public List<PizzaOrder> findBydateOfOrder(LocalDate date);
	public List<PizzaOrder> findByCustomerUserIdAndStatus(Integer customerId, PizzaStatus status);
	public List<PizzaOrder> findByCustomerUserId(Integer customerId);
}
