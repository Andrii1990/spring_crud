package com.javamaster.springcrud.service;

import com.javamaster.springcrud.dto.UsersDto;
import com.javamaster.springcrud.exception.ValidationException;

import java.util.List;

public interface UsersService {
    UsersDto saveUser(UsersDto usersDto) throws ValidationException;
    void  deleteUser(Integer userId);
    UsersDto findByLogin(String login);
    List<UsersDto> findAll();
}
