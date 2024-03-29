package com.kiwi.customvalidationdemo.repository;

import com.kiwi.customvalidationdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int id);
}
