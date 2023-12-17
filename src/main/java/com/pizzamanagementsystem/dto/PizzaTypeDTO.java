package com.pizzamanagementsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class PizzaTypeDTO {
	private Integer pizzaTypeId;
	/*
	 * Veg or Non-Veg
	 */
	private String pizzaType;
	private List<ToppingsDTO> toppings;
}
