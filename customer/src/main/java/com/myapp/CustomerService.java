package com.myapp;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegisterRequest request){
        Customer customer = Customer.builder()
                .first_name(request.first_name())
                .last_name(request.last_name())
                .email(request.email())
                .build();

        // Todo : check if email is valid
        // Todo : Check if email note taken
        // Todo : store customer in DB
    }
}
