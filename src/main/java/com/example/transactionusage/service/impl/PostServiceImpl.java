package com.example.transactionusage.service.impl;

import com.example.transactionusage.dto.request.PostCreateRequest;
import com.example.transactionusage.dto.request.TagCreateRequest;
import com.example.transactionusage.dto.response.PostResponse;
import com.example.transactionusage.dto.response.TagResponse;
import com.example.transactionusage.mapper.PostDtoMapper;
import com.example.transactionusage.model.Post;
import com.example.transactionusage.model.Tag;
import com.example.transactionusage.repository.PostRepository;
import com.example.transactionusage.service.PostService;
import com.example.transactionusage.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class PostServiceImpl implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;
    private final TagService tagService;
    private final PostDtoMapper postDtoMapper;

    public PostServiceImpl(PostRepository postRepository, TagService tagService, PostDtoMapper postDtoMapper) {
        this.postRepository = postRepository;
        this.tagService = tagService;
        this.postDtoMapper = postDtoMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PostResponse createPost(PostCreateRequest postCreateRequest) throws Exception {
        logger.info("req: {}", postCreateRequest);
        Post post = postDtoMapper.convertReqToEntity(postCreateRequest);
        Post savedPost = postRepository.save(post);
        logger.info("===> Post Id: {}", savedPost.getId());
        TagResponse tagResponse = postCreateRequest.getTagResponse();
        TagCreateRequest tagCreateRequest = TagCreateRequest.builder()
                        .name(tagResponse.getName())
                        .build();
        tagService.createTag(tagCreateRequest);
        PostResponse postResponse = postDtoMapper.convertEntityToResp(savedPost);
        return postResponse;
    }

    @Override
    public List<PostResponse> findAll() {
        return postRepository.findAll().stream()
                .map((post) -> postDtoMapper.convertEntityToResp(post))
                .collect(Collectors.toList());
    }
}
