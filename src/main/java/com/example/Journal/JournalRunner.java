package com.example.Journal;

import java.util.ArrayList;
import java.util.Iterator;
        import java.util.List;

import com.example.Journal.Service.UserService;
import com.example.Journal.data.Privilege;
import com.example.Journal.data.PrivilegeRepository;
import com.example.Journal.data.User;
import com.example.Journal.data.UserRepository;
import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class JournalRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(JournalRunner.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public void run(String...args) throws Exception {

     //   userService.saveUser(new User("Suliman", "823749732", "1234Qwer", "saf@gmail.com", [1, 2]));
        privilegeRepository.save(new Privilege("USER"));
        privilegeRepository.save(new Privilege("ADMIN"));
        Privilege userPrivilege1 = privilegeRepository.findByName("ADMIN");
       // Privilege userPrivilege2 = privilegeRepository.findByName("USER");
        List<Privilege> privileges = new ArrayList<>();
        privileges.add(userPrivilege1);
      //  privileges.add(userPrivilege2);
        userRepository.save( new User("Suliman", "0423432432432", new BCryptPasswordEncoder().encode(("1234Qwer")), "saf@gmail.com", privileges));
        System.out.println(privilegeRepository.findAll());
        System.out.println(userRepository.findAll());
    }
}
