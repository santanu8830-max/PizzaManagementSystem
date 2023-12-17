package com.pizzamanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Toppings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer toppingsId;
	private String toppingsName;
	private Double price;
}
