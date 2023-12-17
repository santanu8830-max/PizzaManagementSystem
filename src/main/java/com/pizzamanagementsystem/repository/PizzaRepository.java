package com.pizzamanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagementsystem.entity.Pizza;
import com.pizzamanagementsystem.util.PizzaSize;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	public List<Pizza> findByPizzaCostBetween(Double minPrice, Double maxPrice);

	public List<Pizza> findByPizzaTypePizzaType(String pizzatype);

	public List<Pizza> findByPizzaSize(PizzaSize pizzaSize);
}
