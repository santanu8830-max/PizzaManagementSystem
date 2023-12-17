package com.pizzamanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagementsystem.dto.CustomerDTO;
import com.pizzamanagementsystem.dto.PizzaDTO;
import com.pizzamanagementsystem.dto.PizzaOrderDTO;
import com.pizzamanagementsystem.service.ICustomerService;
import com.pizzamanagementsystem.service.IPizzaOrderService;
import com.pizzamanagementsystem.service.IPizzaService;

@RestController
public class AdminController {

	@Autowired
	ICustomerService customerService;

	@Autowired
	IPizzaService pizzaService;

	@Autowired
	IPizzaOrderService pizzaOrderService;

	@PutMapping("/updateCustomer/{userId}")
	public ResponseEntity<CustomerDTO> updateCustomerByAdmin(@RequestBody CustomerDTO customerdto,
			@PathVariable Integer userId) {
		CustomerDTO allCustomers = customerService.updateCustomer(customerdto, userId);
		return new ResponseEntity<CustomerDTO>(allCustomers, HttpStatus.OK);
	}

	@PostMapping("/addpizzabyadmin")
	public ResponseEntity<PizzaDTO> addPizzaByAdmin(@RequestBody PizzaDTO pizza) {
		PizzaDTO pizzaDTO = pizzaService.addPizza(pizza);
		return new ResponseEntity<PizzaDTO>(pizzaDTO, HttpStatus.OK);
	}

	@DeleteMapping("/cancelpizzaorderbyadmin/{pizzaId}")
	public ResponseEntity<PizzaOrderDTO> cancelPizzaOrder(@PathVariable Integer pizzaId) {
		PizzaOrderDTO pizzaOrderDTO = pizzaOrderService.cancelPizzaOrder(pizzaId);

		if (pizzaOrderDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pizzaOrderDTO, HttpStatus.OK);
	}
}
