package com.example.demo.service;

import com.example.demo.persistance.entities.User;
import com.example.demo.rest.request.UserRequest;
import com.example.demo.service.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void save(UserRequest request);

    UserDto getUser(Long id);

    List<UserDto> getUsers();

}
