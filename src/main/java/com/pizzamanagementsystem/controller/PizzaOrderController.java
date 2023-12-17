package com.pizzamanagementsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagementsystem.dto.PizzaOrderDTO;
import com.pizzamanagementsystem.service.IPizzaOrderService;
import com.pizzamanagementsystem.util.PizzaStatus;

@RestController
public class PizzaOrderController {

	@Autowired
	IPizzaOrderService pos;

	@GetMapping("/allpizzaorder")
	public ResponseEntity<List<PizzaOrderDTO>> viewAllPizzaOrders() {
		List<PizzaOrderDTO> pizzaOrderDTOs = pos.viewAllPizzaOrders();
		return new ResponseEntity<List<PizzaOrderDTO>>(pizzaOrderDTOs, HttpStatus.OK);
	}

	@PostMapping("/addorder")
	public ResponseEntity<PizzaOrderDTO> bookPizzaOrder(@RequestBody PizzaOrderDTO order) {
		PizzaOrderDTO pizzaOrderDTO = pos.bookPizzaOrder(order);
		return new ResponseEntity<PizzaOrderDTO>(pizzaOrderDTO, HttpStatus.OK);
	}

	@PutMapping("/updatepizzaorder/{pizzaOrderId}")
	public ResponseEntity<PizzaOrderDTO> updatepizzaOrder(@PathVariable Integer pizzaOrderId,
			@RequestBody PizzaOrderDTO pizzaOrder) {
		PizzaOrderDTO pizzaOrderDTO = pos.updatepizzaOrder(pizzaOrder, pizzaOrderId);

		return new ResponseEntity<PizzaOrderDTO>(pizzaOrderDTO, HttpStatus.OK);
	}

	@DeleteMapping("/cancelpizzaorder/{pizzaId}")
	public ResponseEntity<PizzaOrderDTO> cancelPizzaOrder(@PathVariable Integer pizzaId) {
		PizzaOrderDTO pizzaOrderDTO = pos.cancelPizzaOrder(pizzaId);
		return new ResponseEntity<>(pizzaOrderDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzaorderbyorderid/{pizzaOrderId}")
	public ResponseEntity<PizzaOrderDTO> viewPizzaOrderById(@PathVariable Integer pizzaOrderId) {
		PizzaOrderDTO pizzaOrderDTO = pos.viewPizzaOrderById(pizzaOrderId);

		return new ResponseEntity<PizzaOrderDTO>(pizzaOrderDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzaorderbydate/{date}")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByDate(@PathVariable LocalDate date) {
		List<PizzaOrderDTO> pizzaOrderDTO = pos.viewPizzaOrderByDate(date);
		return new ResponseEntity<List<PizzaOrderDTO>>(pizzaOrderDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzaorderbyid/{userId}")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByCustomerId(Integer userId) {
		List<PizzaOrderDTO> pizzaOrderDTO = pos.viewPizzaOrderByCustomerId(userId);
		return new ResponseEntity<List<PizzaOrderDTO>>(pizzaOrderDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzaorderbystatus/{status}")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByStatus(PizzaStatus status) {
		List<PizzaOrderDTO> pizzaOrderDTO = pos.viewPizzaOrderByStatus(status);

		return new ResponseEntity<List<PizzaOrderDTO>>(pizzaOrderDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzaorderbystatus/{userId}/{status}")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByCustomerIdAndStatus(Integer userId, PizzaStatus status) {
		List<PizzaOrderDTO> pizzaOrderDTO = pos.viewPizzaOrderByCustomerIdAndStatus(userId, status);
		return new ResponseEntity<List<PizzaOrderDTO>>(pizzaOrderDTO, HttpStatus.OK);
	}
}
