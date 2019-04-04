package com.ms.spring.boot.jpa.repository;

import com.ms.spring.boot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, String> {
    List<User> findByName(String name);
}
