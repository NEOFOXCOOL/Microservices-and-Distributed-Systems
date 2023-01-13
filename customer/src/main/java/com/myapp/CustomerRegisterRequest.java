package com.myapp;

public record CustomerRegisterRequest (
        String first_name,
        String last_name,
        String email
){
}
