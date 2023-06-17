package com.exam.controller;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
//here this method of mapping reutrns all the users
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<String> getAllUsers() throws Exception {
        
        return ResponseEntity.ok("getting all users");
    }

    //create user
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {
    // Check if user with the given username or email already exists
    User existingUser = userService.findByUsernameOrEmail(user.getUsername(), user.getEmail());
    if (existingUser != null) {
        if (existingUser.getUsername().equals(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body("Username already exists");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body("Email already exists");
        }
    }

    // Create user and return success response
    Set<UserRole> roles = new HashSet<>();
    Role role = new Role();
    role.setRoleId(45L);
    role.setRoleName("student");

    UserRole userRole = new UserRole();
    userRole.setUser(user);
    userRole.setRole(role);

    roles.add(userRole);

    User createdUser = this.userService.createUser(user, roles);

    return ResponseEntity.created(new URI("/users/" + createdUser.getId()))
                         .body(createdUser);
}


    // Get user by ID
     @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //delete by user Id
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
        return "deleted"+userId;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable User user) {
        return this.userService.updateUser(user);
    }


}