package com.exam.service;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    

    User getUser(String username);

    void deleteUser(Long userId);

    User getUserById(Long id);


    public User findByUsernameOrEmail(String username, String email);

    User updateUser(User user);
}
