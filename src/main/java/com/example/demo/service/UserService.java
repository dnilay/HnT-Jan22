package com.example.demo.service;

import com.example.demo.shared.UserDto;
import com.example.demo.ui.CreateUserResponseModel;

public interface UserService {

    public CreateUserResponseModel createUser(UserDto userDto);
}
