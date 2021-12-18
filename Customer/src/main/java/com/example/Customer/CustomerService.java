package com.example.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRespository customerdao;

    CustomerService(){
        System.out.println("I am in Customer Service");
    }


}
