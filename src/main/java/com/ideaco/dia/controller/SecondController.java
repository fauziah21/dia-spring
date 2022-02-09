package com.ideaco.dia.controller;

import com.ideaco.dia.dto.UserDTO;
import com.ideaco.dia.response.HandlerResponse;
import com.ideaco.dia.service.SecondService;
import com.ideaco.dia.model.UserModel;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    //function untuk user
    //get data by id
    @GetMapping("/user/{userId}")
    public UserModel getUser(@PathVariable("userId") int userId){
        return secondService.getUserById(userId);
    }

    //create user
    @PostMapping("/user")
    public UserModel createUser(@RequestParam("userName") String userName,
                                @RequestParam("userPassword") String userPassword,
                                @RequestParam("userEmail") String userEmail,
                                @RequestParam("userPhone") String userPhone,
                                @RequestParam("userAddress") String userAddress,
                                @RequestParam("userResume") String userResume){

        return secondService.createUser(userName, userPassword, userEmail, userPhone, userAddress, userResume);
    }

    //find user by email
    @GetMapping("user/email/{userEmail}")
    public UserModel getUserByEmail(@PathVariable("userEmail") String userEmail){
        return secondService.getUserByEmail(userEmail);
    }

    //get all users
    @GetMapping("/users")
    public List<UserModel> getAllUsers(){
        return  secondService.findAllUsers();
    }

    //login
    @PostMapping("/user/email/password")
    public void getUserByEmailAndPassword(HttpServletResponse request, HttpServletResponse response,
                                          @RequestParam("userEmail") String userEmail,
                                          @RequestParam("userPassword") String userPassword){
        UserDTO userByEmail = secondService.getUserByEmailAndPassword(userEmail, userPassword);

        HandlerResponse.responseSuccessOK(response, "success login");
    }

}
