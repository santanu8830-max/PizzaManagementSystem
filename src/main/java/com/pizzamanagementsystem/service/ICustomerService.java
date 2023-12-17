package com.pizzamanagementsystem.service;

import java.util.List;

import com.pizzamanagementsystem.dto.CustomerDTO;

public interface ICustomerService {
	/*
	 * use save method
	 */
	CustomerDTO registerCustomer(CustomerDTO customerdto);

	/*
	 * use save and findById
	 */
	CustomerDTO updateCustomer(CustomerDTO customerdto, Integer userId);

	/*
	 * findByPhoneNo
	 */
	CustomerDTO viewCustomerByPhone(Long phoneNo);

	/*
	 * findAll
	 */

	List<CustomerDTO> viewAllCustomer();

	/*
	 * findById
	 */
	CustomerDTO viewCustomerById(Integer userId);

}
