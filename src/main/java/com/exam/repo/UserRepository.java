package com.exam.repo;

import com.exam.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//here User class batw extend gariyeko ho ani tesko primary(unique) key Long type ko xa
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

    public Optional<User> findById(Long id);

    public User findByUsernameOrEmail(String username, String email);
}
