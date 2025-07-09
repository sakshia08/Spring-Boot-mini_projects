package com.example.beanfactory.util;

import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public class TimeUtility{
    public String getCurrentHourGreeting() {
        int hour = LocalTime.now().getHour();
        if (hour < 12) return "Good morning!";
        else if (hour < 18) return "Good afternoon!";
        else return "Good evening!";
    }
}
