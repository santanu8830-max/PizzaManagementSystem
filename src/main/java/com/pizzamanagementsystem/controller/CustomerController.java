package com.pizzamanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagementsystem.dto.CustomerDTO;
import com.pizzamanagementsystem.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	ICustomerService cs;

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
		List<CustomerDTO> allCustomers = cs.viewAllCustomer();
		return new ResponseEntity<List<CustomerDTO>>(allCustomers, HttpStatus.OK);

	}

	@GetMapping("/customer/{userId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer userId) {
		CustomerDTO allCustomers = cs.viewCustomerById(userId);
		return new ResponseEntity<CustomerDTO>(allCustomers, HttpStatus.OK);
	}

	@GetMapping("/customers/{customerMobile}")
	public ResponseEntity<CustomerDTO> getCustomerByPhone(@PathVariable Long customerMobile) {
		CustomerDTO allCustomers = cs.viewCustomerByPhone(customerMobile);
		return new ResponseEntity<CustomerDTO>(allCustomers, HttpStatus.OK);
	}

	@PostMapping("/addcustomer")
	public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerdto) {
		CustomerDTO allCustomers = cs.registerCustomer(customerdto);
		return new ResponseEntity<CustomerDTO>(allCustomers, HttpStatus.OK);
	}

	@PutMapping("/updatecustomer/{userId}")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerdto,
			@PathVariable Integer userId) {
		CustomerDTO allCustomers = cs.updateCustomer(customerdto, userId);
		return new ResponseEntity<CustomerDTO>(allCustomers, HttpStatus.OK);
	}
}
