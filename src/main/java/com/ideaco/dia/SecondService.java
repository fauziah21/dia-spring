package com.ideaco.dia;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecondService {
    //buat object
    private UserRepository userRepository;
    //buat constructor
    public SecondService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String  sendMessage(String message){
        return "Sending Message "+message;
    }

    //get user by id
    public UserModel getUserById(int userId){
        return userRepository.findById(userId).get();
    }

    //get user by email
    public UserModel getUserByEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail).get();
    }

    //get all user
    public List<UserModel> findAllUsers(){
        return userRepository.findAll();
    }

    //create / register user
    public UserModel createUser(String userName,
                                String userPassword,
                                String userEmail,
                                String userPhone,
                                String userAddress,
                                String userResume){
        //validasi apakah data user alr exists
        Optional<UserModel> userOptional = userRepository.findByUserEmail(userEmail);
        if (userOptional.isPresent()){
            throw new UserRegistrationException("User with email "+userEmail+" already exists");
        }

        UserModel newUser = new UserModel();
        newUser.setUserName(userName);
        newUser.setUserPassword(userPassword);
        newUser.setUserEmail(userEmail);
        newUser.setUserPhone(userPhone);
        newUser.setUserAddress(userAddress);
        newUser.setUserResume(userResume);

        return userRepository.save(newUser);
    }

    //login
    public UserModel getUserByEmailAndPassword(String userEmail, String userPassword){
        Optional<UserModel> userOptional = userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);

        if (userOptional.isEmpty()){
            return null;
        }

        return userOptional.get();
    }
}
