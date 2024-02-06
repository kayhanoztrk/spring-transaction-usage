package com.example.transactionusage.service.impl;

import com.example.transactionusage.dto.request.UserCreateRequest;
import com.example.transactionusage.dto.response.UserResponse;
import com.example.transactionusage.mapper.UserDtoMapper;
import com.example.transactionusage.model.User;
import com.example.transactionusage.repository.UserRepository;
import com.example.transactionusage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserServiceImpl(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        User user = userDtoMapper.convertReqToEntity(userCreateRequest);
        return userDtoMapper.convertEntityToResp(userRepository.save(user));
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserResponse> userResponseList = userRepository.findAll().stream()
                .map((user) -> userDtoMapper.convertEntityToResp(user))
                .collect(Collectors.toList());

        return userResponseList;
    }
}
