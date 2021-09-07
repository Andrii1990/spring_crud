package com.javamaster.springcrud.service;

import com.javamaster.springcrud.dto.UsersDto;
import com.javamaster.springcrud.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public Users fromUserDtoToUser(UsersDto usersDto){
        return Users.builder()
                .id(usersDto.getId())
                .login(usersDto.getLogin())
                .name(usersDto.getName())
                .email(usersDto.getEmail())
                .build();
    }
    public UsersDto fromUserToUserDto(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .name(users.getName())
                .login(users.getLogin())
                .build();
    }
}
