package com.javamaster.springcrud.service;

import com.javamaster.springcrud.dto.UsersDto;
import com.javamaster.springcrud.entity.Users;
import com.javamaster.springcrud.exception.ValidationException;
import com.javamaster.springcrud.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);

    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is Empty");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {

        return usersConverter.fromUserToUserDto(usersRepository.findByLogin(login));
    }

    @Override
    public List<UsersDto> findAll() {
        return null;
    }

}
