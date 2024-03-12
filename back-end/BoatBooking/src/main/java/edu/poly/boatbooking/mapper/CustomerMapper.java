package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.CustomerDto;
import edu.poly.boatbooking.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto (Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getNumId(),
                customer.getBirth(),
                customer.getAddress(),
                customer.getEmail()
        );
    }
    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getNum_id(),
                customerDto.getBirth(),
                customerDto.getAddress(),
                customerDto.getEmail()
        );
    }

}
