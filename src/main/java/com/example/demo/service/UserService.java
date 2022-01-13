package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.shared.UserDto;
import com.example.demo.ui.CreateUserResponseModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public CreateUserResponseModel createUser(UserDto userDto);

    public CreateUserResponseModel getUserById(Long id);

    public List<CreateUserResponseModel> getAllUsers();

    public CreateUserResponseModel findUserByEmail(String email);
}
