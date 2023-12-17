package com.pizzamanagementsystem.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagementsystem.dto.PizzaOrderDTO;
import com.pizzamanagementsystem.service.IPizzaOrderService;
import com.pizzamanagementsystem.util.PizzaStatus;

@RestController
public class ReportingManagementController {

	@Autowired
	IPizzaOrderService pzs;

	@GetMapping("/getReportOfOrderStatus")
	public ResponseEntity<Map<PizzaStatus, Long>> getReportOfOrderByStatus() {
		List<PizzaOrderDTO> pod = pzs.viewAllPizzaOrders();
		Map<PizzaStatus, Long> pizzaReport = pod.stream()
				.collect(Collectors.groupingBy(PizzaOrderDTO::getStatus, Collectors.counting()));
		return new ResponseEntity<>(pizzaReport, HttpStatus.OK);
	}

}
