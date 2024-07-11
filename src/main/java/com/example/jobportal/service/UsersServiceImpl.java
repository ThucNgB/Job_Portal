package com.example.jobportal.service;

import com.example.jobportal.entity.JobSeekerProfile;
import com.example.jobportal.entity.RecruiterProfile;
import com.example.jobportal.entity.Users;
import com.example.jobportal.repository.JobSeekerProfileRepository;
import com.example.jobportal.repository.RecruiterProfileRepository;
import com.example.jobportal.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Override
    public Users addUser(Users user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(user);
        int usersTypeId = user.getUserTypeId().getUserTypeId();
        if (usersTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }

        return savedUser;
    }

    @Override
    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
