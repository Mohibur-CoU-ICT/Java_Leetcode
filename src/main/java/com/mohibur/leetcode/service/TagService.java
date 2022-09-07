package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface TagService {
    ResponseEntity<Tag> createTag(Tag tag);

    ResponseEntity<Tag> getTagById(Long id);

    ResponseEntity<List<Tag>> getAllTags();

    ResponseEntity<Tag> updateTag(Tag tag);

    ResponseEntity<?> deleteTag(Long id);
}
