package com.myapp;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/fraud-check")
public class FraudController {
    private FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponce isFraudster(@PathVariable("customerId") Long customerId){
        boolean isFraudulentCustomer = fraudCheckHistoryService.
                isFraudulentCustomer(customerId);
        return new FraudCheckResponce(isFraudulentCustomer);
    }

}
