package com.example.transactionusage.controller;

import com.example.transactionusage.dto.request.TagCreateRequest;
import com.example.transactionusage.dto.response.TagResponse;
import com.example.transactionusage.service.TagService;
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
@RequestMapping("/api/v1/tag")
public class TagController {

    private static final Logger logger = LoggerFactory.getLogger(TagController.class);
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public List<TagResponse> findAll() {
        return tagService.findAll();
    }

    @PostMapping
    public TagResponse create(@RequestBody TagCreateRequest tagCreateRequest) throws Exception {
        return tagService.createTag(tagCreateRequest);
    }
}
