package edu.poly.boatbooking.service;

import edu.poly.boatbooking.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> getAllCustomers();

    CustomerDto updatedCustomer(Long customerId, CustomerDto updatedCustomer);

    void deleteCustomer(Long customerId);

    CustomerDto findCutomerByName(String name);

}
