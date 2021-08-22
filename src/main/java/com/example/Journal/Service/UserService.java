package com.example.Journal.Service;

import com.example.Journal.Controller.DTO.UserDto;
import com.example.Journal.data.User;

public interface UserService {
    User findByUsername(String username);
    User saveUser(UserDto user);
}
