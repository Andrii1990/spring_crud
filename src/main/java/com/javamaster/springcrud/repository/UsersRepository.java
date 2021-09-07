package com.javamaster.springcrud.repository;

import com.javamaster.springcrud.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
