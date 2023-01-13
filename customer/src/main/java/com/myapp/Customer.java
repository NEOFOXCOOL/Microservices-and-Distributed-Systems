package com.myapp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;
    private String first_name;
    private  String last_name;
    private String email;
}
