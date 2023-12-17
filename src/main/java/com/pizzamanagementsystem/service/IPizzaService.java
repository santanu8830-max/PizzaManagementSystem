package com.pizzamanagementsystem.service;

import java.util.List;

import com.pizzamanagementsystem.dto.PizzaDTO;
import com.pizzamanagementsystem.dto.PizzaTypeDTO;
import com.pizzamanagementsystem.dto.ToppingsDTO;
import com.pizzamanagementsystem.util.PizzaSize;

public interface IPizzaService {
	PizzaDTO addPizza(PizzaDTO pizza);

	ToppingsDTO addToppings(ToppingsDTO toppings);

	PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaType);

	PizzaDTO viewPizzaById(Integer pizzaId);

	List<PizzaDTO> findByPizzaTypePizzaType(String pizzatype);

	List<PizzaDTO> viewPizzaByPizzaSize(PizzaSize pizzaSize);

	List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice);

	List<PizzaDTO> viewAllPizza();

	List<ToppingsDTO> viewToppings();

	ToppingsDTO viewToppingByID(Integer toppingsID);

	PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId);

	List<PizzaTypeDTO> viewAllPizzaTypes();

}
