package com.example.jobportal.service;

import com.example.jobportal.entity.UsersType;
import com.example.jobportal.repository.UsersTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersTypeServiceImpl implements UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;

    @Override
    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }
}
