package com.example.jobportal.service;

import com.example.jobportal.entity.Users;
import com.example.jobportal.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    @Override
    public Users addUser(Users user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        return usersRepository.save(user);
    }
}
