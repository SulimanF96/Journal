package com.example.Journal.Controller;

import com.example.Journal.Controller.DTO.UserDto;
import com.example.Journal.Model.UserModel;
import com.example.Journal.Service.UserService;
import com.example.Journal.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    // everyone
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("permitAll()")
    public User registerUser(@RequestBody UserDto user){
        return userService.saveUser(new UserModel(user.getUsername(), user.getMobileNumber(), user.getPassword(), user.getEmail()));
    }

    // User , Admin
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }


    // ADMIN
    @GetMapping("/adminMessage")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getAdmin(){
        return "Hello Admin";
    }

    // USER
    @GetMapping("/userMessage")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('USER')")
    public String getUser(){
        return "Hello User";
    }

    @GetMapping("/loggedInUser")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("permitAll()")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

}
