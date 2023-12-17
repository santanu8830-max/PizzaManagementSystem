package com.pizzamanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagementsystem.dto.PizzaDTO;
import com.pizzamanagementsystem.dto.PizzaTypeDTO;
import com.pizzamanagementsystem.dto.ToppingsDTO;
import com.pizzamanagementsystem.service.IPizzaService;
import com.pizzamanagementsystem.util.PizzaSize;

@RestController
public class PizzaController {
	@Autowired
	IPizzaService ps;

	@PostMapping("/addpizza")
	public ResponseEntity<PizzaDTO> addPizza(@RequestBody PizzaDTO pizza) {
		PizzaDTO pizzaDTO = ps.addPizza(pizza);
		return new ResponseEntity<PizzaDTO>(pizzaDTO, HttpStatus.OK);
	}

	@PostMapping("/addtoppings")
	public ToppingsDTO addToppings(@RequestBody ToppingsDTO tpdto) {
		return ps.addToppings(tpdto);
	}

	@PostMapping("/addpizzaType")
	public PizzaTypeDTO addPizzaType(@RequestBody PizzaTypeDTO pizzaType) {
		return ps.addPizzaType(pizzaType);
	}

	@GetMapping("/allpizza")
	public ResponseEntity<List<PizzaDTO>> viewAllPizza() {
		List<PizzaDTO> pizzaDTO = ps.viewAllPizza();
		return new ResponseEntity<List<PizzaDTO>>(pizzaDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzabyid/{pizzaId}")
	public ResponseEntity<PizzaDTO> viewPizzaById(@PathVariable Integer pizzaId) {
		PizzaDTO pizzaDTO = ps.viewPizzaById(pizzaId);

		if (pizzaDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pizzaDTO, HttpStatus.OK);
	}

	@GetMapping("/toppingsbyid/{toppingsId}")
	public ResponseEntity<ToppingsDTO> viewToppingById(@PathVariable Integer toppingsId) {
		ToppingsDTO toppingsDTO = ps.viewToppingByID(toppingsId);

		if (toppingsDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toppingsDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzatypebyid/{pizzaTypeId}")
	public ResponseEntity<PizzaTypeDTO> viewPizzaTypeById(@PathVariable Integer pizzaTypeId) {
		PizzaTypeDTO pizzaTypeDTO = ps.viewPizzaTypeById(pizzaTypeId);

		if (pizzaTypeDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pizzaTypeDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzabyprice/{pizzaCost}")
	public ResponseEntity<List<PizzaDTO>> viewPizzaByPrice(Double minPrice, Double maxPrice) {
		List<PizzaDTO> pizzaDTO = ps.viewPizzaByPrice(minPrice, maxPrice);

		return new ResponseEntity<List<PizzaDTO>>(pizzaDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzabytype/{pizzaType}")
	public ResponseEntity<List<PizzaDTO>> viewPizzaByPizzaType(String pizzaType) {
		List<PizzaDTO> pizzaDTO = ps.findByPizzaTypePizzaType(pizzaType);
		return new ResponseEntity<List<PizzaDTO>>(pizzaDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzabysize/{pizzaSize}")
	public ResponseEntity<List<PizzaDTO>> viewPizzaByPizzaSize(@PathVariable PizzaSize pizzaSize) {
		List<PizzaDTO> pizzaDTO = ps.viewPizzaByPizzaSize(pizzaSize);
		return new ResponseEntity<List<PizzaDTO>>(pizzaDTO, HttpStatus.OK);
	}

	@GetMapping("/toppings")
	public ResponseEntity<List<ToppingsDTO>> viewToppings() {
		List<ToppingsDTO> toppingsDTO = ps.viewToppings();
		return new ResponseEntity<List<ToppingsDTO>>(toppingsDTO, HttpStatus.OK);
	}

	@GetMapping("/pizzatypes")
	public ResponseEntity<List<PizzaTypeDTO>> viewAllPizzaTypes() {
		List<PizzaTypeDTO> pizzaTypeDTO = ps.viewAllPizzaTypes();
		return new ResponseEntity<List<PizzaTypeDTO>>(pizzaTypeDTO, HttpStatus.OK);
	}

}
