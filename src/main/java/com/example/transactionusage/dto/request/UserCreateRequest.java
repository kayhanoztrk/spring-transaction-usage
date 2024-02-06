package com.example.transactionusage.dto.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
public class UserCreateRequest {
    private String name;
    private String bio;
}
