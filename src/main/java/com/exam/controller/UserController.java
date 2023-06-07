package com.exam.controller;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
//here this method of mapping reutrns all the users
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Set<UserRole> roles = new HashSet<>();
    Role role = new Role();
    role.setRoleId(45L);
    role.setRoleName("");

    UserRole userRole = new UserRole();
    userRole.setUser(user);

    roles.add();
    //creating User
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user,);
    }
}
