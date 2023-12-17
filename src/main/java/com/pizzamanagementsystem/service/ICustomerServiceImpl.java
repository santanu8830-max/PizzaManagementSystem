
package com.pizzamanagementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagementsystem.dto.CustomerDTO;
import com.pizzamanagementsystem.entity.Customer;
import com.pizzamanagementsystem.exception.CustomerNotFoundException;
import com.pizzamanagementsystem.repository.CustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	CustomerRepository customerRepository;

	/*
	 * to convert entity to DTO
	 */
	private CustomerDTO convertEntityToDto(Customer cu) {
		/*
		 * without model Mapper
		 */
		/*
		 * CustomerDTO cdto=new CustomerDTO();
		 * cdto.setCustomerName(cu.getCustomerName());
		 * cdto.setCustomerMobile(cu.getCustomerMobile());
		 * cdto.setCustomerEmail(cu.getCustomerEmail());
		 * cdto.setCustomerAddress(cu.getCustomerAddress());
		 * cdto.setUserId(cu.getUserId()); cdto.setUserName(cu.getUserName());
		 * cdto.setUserRole(cu.getUserRole()); cdto.setPassword(cu.getPassword());
		 * return cdto;
		 */

		/*
		 * with model Mapper
		 */
		CustomerDTO newcusCustomerDTO = modelMapper.map(cu, CustomerDTO.class);
		return newcusCustomerDTO;
	}

	/*
	 * to convert DTO to entity
	 */
	private Customer convertDtoToEntity(CustomerDTO cuDTO) {
		Customer newCustomer = modelMapper.map(cuDTO, Customer.class);
		return newCustomer;
	}

	/*
	 * use save method for create a new customer
	 */
	@Override
	public CustomerDTO registerCustomer(CustomerDTO customerdto) {
		Customer newCustomer = convertDtoToEntity(customerdto);
		newCustomer = customerRepository.save(newCustomer);
		CustomerDTO custdto = convertEntityToDto(newCustomer);
		return custdto;
	}

	/*
	 * use save method and findbyId Method for update the customer
	 */
	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerdto, Integer userId) {
		Optional<Customer> cus = customerRepository.findById(userId);
		if (!cus.isPresent()) {
			throw new CustomerNotFoundException("Unable to Find Customer Id ");
		}
		Customer cusnew = cus.get();
		cusnew.setCustomerName(customerdto.getCustomerName());
		cusnew.setCustomerMobile(customerdto.getCustomerMobile());
		cusnew.setCustomerEmail(customerdto.getCustomerEmail());
		cusnew.setCustomerAddress(customerdto.getCustomerAddress());
		cusnew = customerRepository.save(cusnew);
		return convertEntityToDto(cusnew); // return the user given dto
	}

	/*
	 * find by mobile no to view the customer
	 */
	@Override
	public CustomerDTO viewCustomerByPhone(Long customerMobile) {
		Customer newcu = customerRepository.findByCustomerMobile(customerMobile);
		if (newcu == null)
			throw new CustomerNotFoundException("Customer Not Found For Mobile :" + customerMobile);

		CustomerDTO newcudto = convertEntityToDto(newcu);
		return newcudto;
	}

	/*
	 * for view all customer details
	 */
	@Override
	public List<CustomerDTO> viewAllCustomer() {
		List<Customer> customer = customerRepository.findAll();
		if (customer.size() == 0 || customer == null)
			throw new CustomerNotFoundException("Customers Not Available");

		return customer.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	/*
	 * view customer by id
	 */
	@Override
	public CustomerDTO viewCustomerById(Integer userId) {
		Optional<Customer> newCustomer = customerRepository.findById(userId);
		if (!newCustomer.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found for Id :" + userId);
		}
		Customer customer = newCustomer.get();
		CustomerDTO newCdto = convertEntityToDto(customer);
		return newCdto;
	}

}
