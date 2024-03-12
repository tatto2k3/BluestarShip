package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerIdByNumId(String numId);
    Customer findCustomerByName(String name);
}
