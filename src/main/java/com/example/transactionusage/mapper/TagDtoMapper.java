package com.example.transactionusage.mapper;

import com.example.transactionusage.dto.request.TagCreateRequest;
import com.example.transactionusage.dto.response.TagResponse;
import com.example.transactionusage.model.Tag;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class TagDtoMapper {

    public Tag convertReqToEntity(TagCreateRequest tagCreateRequest){
        Tag tag = Tag.builder()
                .name(tagCreateRequest.getName())
                .build();
        return tag;
    }

    public TagResponse convertEntityToResp(Tag tag){
        TagResponse tagResponse = TagResponse.builder()
                .name(tag.getName())
                .build();

        return tagResponse;
    }
}
