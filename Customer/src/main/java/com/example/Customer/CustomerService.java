package com.example.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    CustomerService(){

        System.out.println("I am in Customer Service");
    }

    public Customer getCustomerByID(int id) throws SQLException {
        return customerRespository.getCustomer(id);
    }

    public void createCustomer(CustomerCreateRequest customerCreateRequest) throws SQLException{
        customerRespository.create(customerCreateRequest.toCustomer());
    }
}
