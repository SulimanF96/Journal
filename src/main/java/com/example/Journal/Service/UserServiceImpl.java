package com.example.Journal.Service;

import com.example.Journal.Model.PrivilegeModel;
import com.example.Journal.Model.UserModel;
import com.example.Journal.data.Privilege;
import com.example.Journal.data.PrivilegeRepository;
import com.example.Journal.data.User;
import com.example.Journal.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PrivilegeRepository privilegeRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PrivilegeRepository privilegeRepository) {
        this.userRepository = userRepository;
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public User saveUser(UserModel user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setMobileNumber(user.getMobileNumber());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode((user.getPassword())));
        Privilege userPrivilege = privilegeRepository.findByName("USER");
        List<Privilege> privileges = new ArrayList<>();
        privileges.add(userPrivilege);
        newUser.setPrivileges(privileges);
        return userRepository.save(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
