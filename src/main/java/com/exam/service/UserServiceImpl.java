package com.exam.service;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //This method is for creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        //yeadi pailai same username vako db ma xa vani yesle alert pathaunexa
        User local = this.userRepository.findByUserName(user.getUsername());
        if (local != null) {
            System.out.println("User is already there");
            throw new Exception("Already same person is available in database");
        }else {

        }
        return null;
    }
}
