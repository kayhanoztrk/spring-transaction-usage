package com.example.transactionusage.mapper;

import com.example.transactionusage.dto.request.UserCreateRequest;
import com.example.transactionusage.dto.response.UserResponse;
import com.example.transactionusage.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class UserDtoMapper {

    public User convertReqToEntity(UserCreateRequest userDto){
        User user = User.builder()
                .name(userDto.getName())
                .bio(userDto.getBio())
                .build();
        return user;
    }

    public UserResponse convertEntityToResp(User user){
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .bio(user.getBio())
                .createdAt(user.getCreatedAt())
                .build();

        return userResponse;
    }
}
