package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.shared.UserDto;
import com.example.demo.ui.CreateUserRequestModel;
import com.example.demo.ui.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Validated @RequestBody CreateUserRequestModel userDetails)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=modelMapper.map(userDetails,UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        StringBuilder sb=new StringBuilder();
        sb.append(userDto.getPassword());
        userDto.setEncryptedPassword(sb.reverse().toString());
        CreateUserResponseModel userResponseModel=userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);

    }
}
