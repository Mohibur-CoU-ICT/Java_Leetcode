package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Tag;
import com.mohibur.leetcode.interfaces.UrlConstant;
import com.mohibur.leetcode.serviceImpl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.TagUrl.ROOT)
public class TagController {
    @Autowired
    private TagServiceImpl tagService;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Tag> getTag(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return tagService.getAllTags();
    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        return tagService.updateTag(tag);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        return tagService.deleteTag(id);
    }
}
