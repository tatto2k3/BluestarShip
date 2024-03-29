package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.dto.CustomerDto;
import edu.poly.boatbooking.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        if (savedCustomer == null) return new ResponseEntity<>(savedCustomer, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customerDtos = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long customerId,
                                                      @RequestBody CustomerDto updatedCustomer){
        CustomerDto customerDto = customerService.updatedCustomer(customerId,updatedCustomer);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Delete customer successfully@!");
    }
}
