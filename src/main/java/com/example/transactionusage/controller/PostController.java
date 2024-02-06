package com.example.transactionusage.controller;

import com.example.transactionusage.dto.request.PostCreateRequest;
import com.example.transactionusage.dto.response.PostResponse;
import com.example.transactionusage.service.PostService;
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
@RequestMapping("/api/v1/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    @PostMapping
    public PostResponse create(@RequestBody PostCreateRequest postCreateRequest) throws Exception {
        logger.info("postCreateReq: {}", postCreateRequest);
        PostResponse response = postService.createPost(postCreateRequest);
        return response;
    }
}
