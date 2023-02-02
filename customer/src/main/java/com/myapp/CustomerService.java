package com.myapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegisterRequest request){
        // Todo : check if email is valid
        // Todo : Check if email note taken
        // Todo : store customer in DB
        // TODO : Check if fraudster
        // TODO : send notification
        Customer customer = Customer.builder()
                .first_name(request.first_name())
                .last_name(request.last_name())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponce fraudCheckResponce = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponce.class,
                customer.getId()
        );

        if(fraudCheckResponce.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }


    }
}
