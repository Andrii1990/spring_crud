package com.javamaster.springcrud.service;


import com.javamaster.springcrud.dto.UsersDto;
import com.javamaster.springcrud.entity.Users;
import com.javamaster.springcrud.exception.ValidationException;
import com.javamaster.springcrud.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultUsersServiceTest {
    private UsersService usersService;
    private UsersRepository usersRepository;
    private UsersConverter usersConverter;
    private Users users;

    @BeforeEach
    void setUp() {
        usersRepository = mock(UsersRepository.class);
        usersConverter = new UsersConverter();
        users = Users.builder().name("testName").login("testLogin").id(1).build();
        when(usersRepository.save(any())).thenReturn(users);
        usersService = new DefaultUsersService(usersRepository, usersConverter);
    }

    @Test
    void saveUserReturnUserDto() throws ValidationException {
        UsersDto usersDto = UsersDto.builder().login("testLogin").build();
        UsersDto  savedUsersDto = usersService.saveUser(usersDto);
        assertThat(savedUsersDto).isNotNull();
        assertThat(savedUsersDto.getLogin()).isEqualTo("testLogin");
    }

    @Test
    void saveUserWithNullLoginThrowsValidationException() {
        UsersDto usersDto = UsersDto.builder().build();
        assertThrows(ValidationException.class , ()-> usersService.saveUser(usersDto), "Login is empty");
    }
}