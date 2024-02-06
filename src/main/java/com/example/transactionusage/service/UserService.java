package com.example.transactionusage.service;

import com.example.transactionusage.dto.request.UserCreateRequest;
import com.example.transactionusage.dto.response.UserResponse;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface UserService {
    UserResponse createUser(UserCreateRequest userCreateRequest);
    List<UserResponse> findAll();
}
