package com.example.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{customerid}")
    private Customer getCustomerDetails(@PathVariable("customerid") int custid) throws SQLException {

        return customerService.getCustomerByID(custid);

    }

    @GetMapping("/")
    private String welcome(){
        return "<h2>Hello, There</h2>";
    }

    @PostMapping("/create")
    private void createCustomer(@Valid @RequestBody CustomerCreateRequest customerCreateRequest) throws SQLException {
        customerService.createCustomer(customerCreateRequest);


    }
}
