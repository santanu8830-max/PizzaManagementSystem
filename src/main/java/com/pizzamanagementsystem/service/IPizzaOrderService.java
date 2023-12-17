package com.pizzamanagementsystem.service;

import java.time.LocalDate;
import java.util.List;

import com.pizzamanagementsystem.dto.PizzaOrderDTO;
import com.pizzamanagementsystem.util.PizzaStatus;

public interface IPizzaOrderService {
	PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order);

	PizzaOrderDTO updatepizzaOrder(PizzaOrderDTO pizzaOrder, Integer userId);

	PizzaOrderDTO cancelPizzaOrder(Integer pizzaId);

	PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId);

	List<PizzaOrderDTO> viewAllPizzaOrders();

	/*
	 * Customize Methods
	 */

	List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date);

	List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer userId);

	List<PizzaOrderDTO> viewPizzaOrderByStatus(PizzaStatus status);

	List<PizzaOrderDTO> viewPizzaOrderByCustomerIdAndStatus(Integer customerId, PizzaStatus status);

}
