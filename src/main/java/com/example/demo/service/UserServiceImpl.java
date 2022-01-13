package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.shared.UserDto;
import com.example.demo.ui.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    @Override
    public CreateUserResponseModel getUserById(Long id) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Optional<UserEntity> optionalUserEntity= userRepository.findById(id);
        return modelMapper.map(optionalUserEntity.get(),CreateUserResponseModel.class);
    }

    @Override
    public List<CreateUserResponseModel> getAllUsers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CreateUserResponseModel> createUserResponseModels=new ArrayList<>();
        Iterable<UserEntity> iterable= userRepository.findAll();
        Iterator<UserEntity> iterator=iterable.iterator();
        while(iterator.hasNext())
        {
            createUserResponseModels.add(modelMapper.map(iterator.next(),CreateUserResponseModel.class));
        }


        return createUserResponseModels;
    }

    @Override
    public Optional<CreateUserResponseModel> findUserByEmail(String email) {
        return Optional.empty();
    }


}
