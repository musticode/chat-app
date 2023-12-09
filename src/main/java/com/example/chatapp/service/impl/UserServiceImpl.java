package com.example.chatapp.service.impl;

import com.example.chatapp.dto.user.UserCreateRequest;
import com.example.chatapp.dto.user.UserCreateResponse;
import com.example.chatapp.dto.user.UserDto;
import com.example.chatapp.exception.UserNotFoundException;
import com.example.chatapp.model.User;
import com.example.chatapp.repository.UserRepository;
import com.example.chatapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserCreateResponse createUser(UserCreateRequest request) {

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mail(request.getMail())
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        userRepository.save(user);


        return modelMapper.map(user, UserCreateResponse.class);
    }

    @Override
    public UserDto findUserById(long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(
                        ()-> new UserNotFoundException(String.format("User not found with %s", userId)
                        )
                );

        return mapToUserDto(user);
    }

    private User findUserWithId(long userId){
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }

    private UserDto mapToUserDto(User user){
        if (user == null)
            throw new NullPointerException();
        return modelMapper.map(user, UserDto.class);
    }

}
