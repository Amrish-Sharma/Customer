package com.example.Customer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;


@Component

public class CustomerRespository {

    private static Logger logger=LoggerFactory.getLogger(CustomerRespository.class);

    private Connection connection;

    private CustomerRespository(
            @Value("${my_db.username}") String username,
            @Value("${my_db.password}") String password) throws SQLException
    {
        connection = getConnection(username,password);
        createTable();

    }

    private void createTable() throws SQLException {

        Statement statement=connection.createStatement();

        boolean result=
                statement.execute("create table if not exists customerinfo(id int primary key, name varchar(30), age int, phone varchar(10), email varchar(30), address varchar(56))");
        logger.info("table customer info is created- {}",result);
    }

    private Connection getConnection(String username, String password) throws SQLException {

        logger.info("username - {} & password - {}", username,password);
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/customer",username,password);
    }

    public Customer getCustomer(int id) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from customerinfo where id="+id);

        logger.info("got the result set - {}", resultSet);

        while(resultSet.next()) {
            int customerId = resultSet.getInt("id");
            String customername = resultSet.getString("name");
            String customeremail = resultSet.getString("email");
            int customerage = resultSet.getInt("age");
            String customeraddress = resultSet.getString("address");
            String customerphone = resultSet.getString("phone");


         return Customer.builder()
                .id(customerId)
                .age(customerage)
                .name(customername)
                .email(customeremail)
                .phone(customerphone)
                .address(customeraddress)
                .build();
        }
        return null;

    }

    public void create(Customer customer) throws SQLException{
        PreparedStatement statement=connection.prepareStatement("insert into customerinfo(name,age,phone,email,address) VALUES(?,?,?,?,?)");

        statement.setString(1,customer.getName());
        statement.setInt(2,customer.getAge());
        statement.setString(3,customer.getPhone());
        statement.setString(4,customer.getEmail());
        statement.setString(5,customer.getAddress());

        boolean result=statement.execute();
        logger.info("Resul of Insert query is "+ result);


    }


}
