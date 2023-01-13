package com.myapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/customers")
public record CustomerController(CustomerService customerService) {

    public void resgisterCustomer(CustomerRegisterRequest customerRegisterRequest){
        log.info("new customer registration",customerRegisterRequest);
    }
}
