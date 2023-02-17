package com.mohibur.problem_solving.controller;

import com.mohibur.problem_solving.serviceImpl.TagServiceImpl;
import com.mohibur.problem_solving.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagServiceImpl tagService;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tag>> getAllTags() {
        return tagService.getAllTags();
    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        return tagService.updateTag(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        return tagService.deleteTag(id);
    }
}
