package com.ideaco.dia;

import org.springframework.stereotype.Service;

@Service
public class SecondService {
    public String  sendMessage(String message){
        return "Sending Message "+message;
    }
}
