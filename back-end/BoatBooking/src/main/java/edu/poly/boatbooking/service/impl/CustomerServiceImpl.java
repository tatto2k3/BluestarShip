package edu.poly.boatbooking.service.impl;

import edu.poly.boatbooking.dto.CustomerDto;
import edu.poly.boatbooking.entity.Boat;
import edu.poly.boatbooking.entity.Customer;
import edu.poly.boatbooking.exception.ResourceNotFoundException;
import edu.poly.boatbooking.mapper.BoatMapper;
import edu.poly.boatbooking.mapper.CustomerMapper;
import edu.poly.boatbooking.repository.CustomerRepository;
import edu.poly.boatbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        if (!customerRepository.existsById(customer.getId())) {
            Customer saveCustomer = customerRepository.save(customer);
            return CustomerMapper.mapToCustomerDto(saveCustomer);
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer is not exists with given id: " + customerId));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updatedCustomer(Long customerId, CustomerDto updatedCustomer) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer is not exists with given id: " + customerId)
        );
        customer.setName(updatedCustomer.getName());
        customer.setNumId(updatedCustomer.getNum_id());
        customer.setBirth(updatedCustomer.getBirth());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setEmail(updatedCustomer.getEmail());

        Customer updatedCustomerObj = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer is not exists with given id: " + customerId)
        );

        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDto findCutomerByName(String name) {
        Customer customer = customerRepository.findCustomerByName(name);
        return CustomerMapper.mapToCustomerDto(customer);
    }


}
