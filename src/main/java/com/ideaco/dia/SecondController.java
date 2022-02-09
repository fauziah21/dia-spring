package com.ideaco.dia;

import org.springframework.web.bind.annotation.*;

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
    public String getUserByEmailAndPassword(@RequestParam("userEmail") String userEmail,
                                            @RequestParam("userPassword") String userPassword){
        UserModel userByEmail = secondService.getUserByEmailAndPassword(userEmail, userPassword);
        if (userByEmail != null){
            return "success login";
        }else{
//            return new UserModel();
            return "salah email / password";
        }
    }


}
