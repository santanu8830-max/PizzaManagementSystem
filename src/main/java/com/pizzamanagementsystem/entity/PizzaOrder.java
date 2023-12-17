package com.pizzamanagementsystem.entity;

import java.time.LocalDate;
import java.util.List;

import com.pizzamanagementsystem.util.PizzaStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MyOrder")
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;

	private LocalDate dateOfOrder;
	private Integer quantity;
	private Double totalCost;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Pizza> pizzaList;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@Enumerated(EnumType.STRING)
	private PizzaStatus status;

}
