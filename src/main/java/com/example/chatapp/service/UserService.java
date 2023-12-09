package com.example.chatapp.service;

import com.example.chatapp.dto.user.UserCreateRequest;
import com.example.chatapp.dto.user.UserCreateResponse;
import com.example.chatapp.dto.user.UserDto;

public interface UserService {
    UserCreateResponse createUser(UserCreateRequest request);
    UserDto findUserById(long userId);
}
