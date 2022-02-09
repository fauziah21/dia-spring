package com.ideaco.dia.repository;

import com.ideaco.dia.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    //mencari data berdasarkan email
    Optional<UserModel> findByUserEmail(String userEmail);

    //login
    Optional<UserModel>findByUserEmailAndUserPassword(String userEmail, String userPassword);

}
