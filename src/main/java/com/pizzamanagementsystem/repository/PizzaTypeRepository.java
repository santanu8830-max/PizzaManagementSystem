package com.pizzamanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagementsystem.entity.PizzaType;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType, Integer> {

}
