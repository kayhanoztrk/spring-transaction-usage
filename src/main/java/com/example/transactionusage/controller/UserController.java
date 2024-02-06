package com.example.transactionusage.controller;

import com.example.transactionusage.dto.request.PostCreateRequest;
import com.example.transactionusage.dto.request.UserCreateRequest;
import com.example.transactionusage.dto.response.UserResponse;
import com.example.transactionusage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserResponse create(@RequestBody UserCreateRequest userCreateRequest) {
        UserResponse response = userService.createUser(userCreateRequest);
        return response;
    }
}
