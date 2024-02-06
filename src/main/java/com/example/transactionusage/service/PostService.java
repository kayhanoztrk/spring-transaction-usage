package com.example.transactionusage.service;

import com.example.transactionusage.dto.request.PostCreateRequest;
import com.example.transactionusage.dto.response.PostResponse;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface PostService {
    PostResponse createPost(PostCreateRequest postCreateRequest) throws Exception;
    List<PostResponse> findAll();
}
