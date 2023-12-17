package com.pizzamanagementsystem.dto;

import java.time.LocalDate;
import java.util.List;

import com.pizzamanagementsystem.util.PizzaStatus;

import lombok.Data;

@Data
public class PizzaOrderDTO {
	private Integer bookingOrderId;
	private LocalDate dateOfOrder;
	private Integer quantity;
	private Double totalCost;
	private List<PizzaDTO> pizzaList;
	private CustomerDTO customer;
	private PizzaStatus status;
}
