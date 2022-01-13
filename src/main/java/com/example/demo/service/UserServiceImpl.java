package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.shared.UserDto;
import com.example.demo.ui.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateUserResponseModel createUser(UserDto userDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=userRepository.save(modelMapper.map(userDto,UserEntity.class));
        return modelMapper.map(userEntity,CreateUserResponseModel.class);
    }
}
