package com.example.Customer;


import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateRequest {

    @Min(value = 1)
    @Max(value = 100)
    private int age;


    @NotBlank  // Size not 0 + Not null
    @Size(min = 1, max = 20)
    private String name;

    @NotBlank  // Size not 0 + Not null
    @Size(min = 1, max = 50)
    private String address;

    @Email
    private String email;

    @NotEmpty
    private String phone;


    public Customer toCustomer(){
        return Customer.builder()
                .name(name)
                .email(email)
                .address(address)
                .age(age)
                .phone(phone)
                .build();
    }
}
