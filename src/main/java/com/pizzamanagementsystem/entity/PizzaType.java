package com.pizzamanagementsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PizzaType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaTypeId;

	private String pizzaType;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Toppings> toppings;
}
