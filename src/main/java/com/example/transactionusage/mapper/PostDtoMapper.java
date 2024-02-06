package com.example.transactionusage.mapper;

import com.example.transactionusage.dto.request.PostCreateRequest;
import com.example.transactionusage.dto.response.PostResponse;
import com.example.transactionusage.dto.response.TagResponse;
import com.example.transactionusage.model.Post;
import com.example.transactionusage.model.Status;
import com.example.transactionusage.model.Tag;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class PostDtoMapper {

    public Post convertReqToEntity(PostCreateRequest postCreateRequest) {
        Tag tag = Tag.builder()
                .name(postCreateRequest.getTagResponse().getName())
                .build();

        Post post = Post.builder()
                .title(postCreateRequest.getTitle())
                .description(postCreateRequest.getDescription())
                .tag(tag)
                .createdAt(new Date())
                .build();
        return post;
    }


    public Post convertRespToEntity(PostResponse postResponse) {

        TagResponse tagResponse = postResponse.getTagResponse();
        Tag tag = Tag.builder()
                .name(tagResponse.getName())
                .build();

        Post post = Post.builder()
                .title(postResponse.getTitle())
                .description(postResponse.getDescription())
                .tag(tag)
                .build();

        return post;
    }


    public PostResponse convertEntityToResp(Post post) {

        Tag tag = post.getTag();
        TagResponse tagResponse = TagResponse.builder()
                .name(tag.getName())
                .build();

        PostResponse postResponse = PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .tagResponse(tagResponse)
                .status(Status.DRAFT)
                .createdAt(post.getCreatedAt())
                .build();

        return postResponse;
    }
}
