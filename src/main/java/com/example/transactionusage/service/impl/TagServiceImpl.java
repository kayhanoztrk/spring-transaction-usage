package com.example.transactionusage.service.impl;

import com.example.transactionusage.dto.request.TagCreateRequest;
import com.example.transactionusage.dto.response.TagResponse;
import com.example.transactionusage.mapper.TagDtoMapper;
import com.example.transactionusage.model.Tag;
import com.example.transactionusage.repository.TagRepository;
import com.example.transactionusage.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class TagServiceImpl implements TagService {
    private static final Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

    private final TagRepository tagRepository;
    private final TagDtoMapper tagDtoMapper;

    public TagServiceImpl(TagRepository tagRepository, TagDtoMapper tagDtoMapper) {
        this.tagRepository = tagRepository;
        this.tagDtoMapper = tagDtoMapper;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    //@Transactional(propagation = Propagation.SUPPORTS)
    //@Transactional(propagation = Propagation.NEVER)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public TagResponse createTag(TagCreateRequest tagCreateRequest) throws Exception {
        Tag tag = tagDtoMapper.convertReqToEntity(tagCreateRequest);
        Tag savedTag = tagRepository.save(tag);
        logger.info("===> Tag Id: {}", savedTag.getId());
        if(tagCreateRequest.getName().equals("name"))
            throw new Exception("tag will not be registered");

        return tagDtoMapper.convertEntityToResp(savedTag);
    }

    @Override
    public List<TagResponse> findAll() {
        List<TagResponse> tagResponseList = tagRepository.findAll().stream()
                .map((tag) -> tagDtoMapper.convertEntityToResp(tag))
                .collect(Collectors.toList());
        return tagResponseList;
    }
}
