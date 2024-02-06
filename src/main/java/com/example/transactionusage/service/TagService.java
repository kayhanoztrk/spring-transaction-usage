package com.example.transactionusage.service;

import com.example.transactionusage.dto.request.TagCreateRequest;
import com.example.transactionusage.dto.response.TagResponse;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface TagService {
    TagResponse createTag(TagCreateRequest tagCreateRequest) throws Exception;
    List<TagResponse> findAll();
}
