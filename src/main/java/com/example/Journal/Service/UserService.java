package com.example.Journal.Service;

import com.example.Journal.Model.UserModel;
import com.example.Journal.data.User;

public interface UserService {
    User findByUsername(String username);
    User saveUser(UserModel user);
}
