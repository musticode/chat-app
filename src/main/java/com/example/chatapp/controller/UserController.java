package com.example.chatapp.controller;

import com.example.chatapp.dto.user.UserCreateRequest;
import com.example.chatapp.dto.user.UserCreateResponse;
import com.example.chatapp.dto.user.UserDto;
import com.example.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest request){
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findUserById(@PathVariable long userId){
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }



}
