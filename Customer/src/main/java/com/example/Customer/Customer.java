package com.example.Customer;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {

    int id;
    String name;
    int age;
    String phone;
    String email;
    String address;
}
