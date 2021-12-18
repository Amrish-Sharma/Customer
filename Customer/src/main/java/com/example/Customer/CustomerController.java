package com.example.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{customerid}")
    private String getCustomerDetails(@PathVariable("customerid") int custid){

        return "Customer ID is "+custid;

    }

/*    @PostMapping("/create")
    public void createCustomer(@RequestBody("customer"))*/
}
