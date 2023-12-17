package com.pizzamanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagementsystem.entity.Toppings;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Integer> {

}
