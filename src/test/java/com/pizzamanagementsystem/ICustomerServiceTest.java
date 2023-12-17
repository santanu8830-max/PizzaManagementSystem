package com.pizzamanagementsystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.pizzamanagementsystem.dto.CustomerDTO;
import com.pizzamanagementsystem.entity.Customer;
import com.pizzamanagementsystem.repository.CustomerRepository;
import com.pizzamanagementsystem.service.ICustomerServiceImpl;

class ICustomerServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private ICustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterCustomer() {
        // Arrange
        CustomerDTO inputCustomerDTO = new CustomerDTO(/* initialize with test data */);
        Customer inputCustomerEntity = modelMapper.map(inputCustomerDTO, Customer.class);
        when(customerRepository.save(any(Customer.class))).thenReturn(inputCustomerEntity);
        when(modelMapper.map(any(Customer.class), eq(CustomerDTO.class))).thenReturn(inputCustomerDTO);

        // Act
        CustomerDTO result = customerService.registerCustomer(inputCustomerDTO);

        // Assert
        assertNotNull(result);
        assertEquals(inputCustomerDTO, result);
      
    }

    @Test
    void testUpdateCustomer() {
        // Arrange
        Integer userId = 1;
        CustomerDTO inputCustomerDTO = new CustomerDTO(/* initialize with test data */);
        Customer existingCustomer = new Customer(/* initialize with existing data */);
        Optional<Customer> optionalExistingCustomer = Optional.of(existingCustomer);

        when(customerRepository.findById(userId)).thenReturn(optionalExistingCustomer);
        when(customerRepository.save(any(Customer.class))).thenReturn(existingCustomer);
        when(modelMapper.map(any(Customer.class), eq(CustomerDTO.class))).thenReturn(inputCustomerDTO);

        // Act
        CustomerDTO result = customerService.updateCustomer(inputCustomerDTO, userId);

        // Assert
        assertNotNull(result);
        assertEquals(inputCustomerDTO, result);
      
    }

    @Test
    void testViewCustomerByPhone() {
        // Arrange
        Long customerMobile = 1234567890L;
        Customer existingCustomer = new Customer(/* initialize with existing data */);

        when(customerRepository.findByCustomerMobile(customerMobile)).thenReturn(existingCustomer);
        when(modelMapper.map(any(Customer.class), eq(CustomerDTO.class))).thenReturn(new CustomerDTO());

        // Act
        CustomerDTO result = customerService.viewCustomerByPhone(customerMobile);

        // Assert
        assertNotNull(result);
     
    }

    @Test
    void testViewAllCustomer() {
        // Arrange
        List<Customer> mockCustomers = new ArrayList<>(); // Initialize with mock data
        mockCustomers.add(new Customer(/* initialize with test data */));
        mockCustomers.add(new Customer(/* initialize with test data */));

        List<CustomerDTO> mockCustomerDTOs = new ArrayList<>();
        mockCustomerDTOs.add(new CustomerDTO(/* initialize with test data */));
        mockCustomerDTOs.add(new CustomerDTO(/* initialize with test data */));

        when(customerRepository.findAll()).thenReturn(mockCustomers);
        when(modelMapper.map(any(Customer.class), eq(CustomerDTO.class))).thenReturn(mockCustomerDTOs.get(0),
                mockCustomerDTOs.get(1));

        // Act
        List<CustomerDTO> result = customerService.viewAllCustomer();

        // Assert
        assertNotNull(result);
        assertEquals(mockCustomers.size(), result.size());
    
    }

    @Test
    void testViewCustomerById() {
        // Arrange
        Integer userId = 1;
        Customer existingCustomer = new Customer(/* initialize with existing data */);
        Optional<Customer> optionalExistingCustomer = Optional.of(existingCustomer);

        when(customerRepository.findById(userId)).thenReturn(optionalExistingCustomer);
        when(modelMapper.map(any(Customer.class), eq(CustomerDTO.class))).thenReturn(new CustomerDTO());

        // Act
        CustomerDTO result = customerService.viewCustomerById(userId);

        // Assert
        assertNotNull(result);

    }
}

