package com.pizzamanagementsystem.dto;

import com.pizzamanagementsystem.util.PizzaSize;

import lombok.Data;

@Data
public class PizzaDTO {
	private Integer pizzaId;
	private PizzaTypeDTO pizzaType;
	private String pizzaName;
	private String pizzaDescription;
	private Double pizzaCost;
	private PizzaSize pizzaSize;
}
