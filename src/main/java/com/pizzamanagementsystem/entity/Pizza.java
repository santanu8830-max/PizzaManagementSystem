package com.pizzamanagementsystem.entity;

import com.pizzamanagementsystem.util.PizzaSize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaId;

	@OneToOne(cascade = CascadeType.ALL)
	private PizzaType pizzaType;

	private String pizzaName;
	private String pizzaDescription;

	private Double pizzaCost;

	@Enumerated(EnumType.STRING)
	private PizzaSize pizzaSize;
}
