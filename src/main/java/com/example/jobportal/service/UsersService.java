package com.example.jobportal.service;

import com.example.jobportal.entity.Users;
import org.apache.catalina.User;

import java.util.Optional;

public interface UsersService {

    Users addUser(Users user);

    Optional<Users> getUserByEmail(String email);

}
