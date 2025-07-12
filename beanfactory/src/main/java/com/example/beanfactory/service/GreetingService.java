package com.example.beanfactory.service;

import com.example.beanfactory.repo.GreetingRepository;
import com.example.beanfactory.util.TimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository repository;
    private final TimeUtility timeUtility;

    @Autowired
    public GreetingService(GreetingRepository repository, TimeUtility timeUtility) {
        this.repository = repository;
        this.timeUtility = timeUtility;
    }

    public String getPersonalGreeting(String name) {
        return repository.getGreetingMessage() + " " + name + "! " + timeUtility.getCurrentHourGreeting();
    }
}

