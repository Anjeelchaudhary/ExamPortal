package com.cafateria.handeling.cafe.dao;

import com.cafateria.handeling.cafe.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
