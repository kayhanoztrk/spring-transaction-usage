package com.example.transactionusage.dto.request;

import com.example.transactionusage.dto.response.TagResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
public class PostCreateRequest {
    private String title;
    private String description;

    private TagResponse tagResponse;
}
