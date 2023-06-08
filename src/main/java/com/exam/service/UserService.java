package com.exam.service;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by user name
    public User getUser(String username);

    //delete by user id
    public void deleteUser(Long userId);
}
