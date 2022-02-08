package com.ideaco.dia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class SecondController {

    //buat objeck dari service untuk menghubungkan dengan SecondService class
    private SecondService secondService;

    //constructor
    public SecondController(SecondService secondService){
        this.secondService = secondService;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "hai world";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        return secondService.sendMessage(message);
    }
}
