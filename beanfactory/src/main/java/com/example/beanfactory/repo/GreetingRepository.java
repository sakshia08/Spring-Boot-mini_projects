package com.example.beanfactory.repo;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepository {
    public String getGreetingMessage(){
        return "Hey there,";
    }
}
