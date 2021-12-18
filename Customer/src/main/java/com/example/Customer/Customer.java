package com.example.Customer;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {

    private int id;
    private String name;
    private int age;
    private String phone;
    private String email;
    private String address;
}
