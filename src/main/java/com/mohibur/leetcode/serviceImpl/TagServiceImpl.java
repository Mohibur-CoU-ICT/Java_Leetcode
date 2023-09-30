package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Tag;
import com.mohibur.leetcode.repository.TagRepository;
import com.mohibur.leetcode.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public ResponseEntity<Tag> createTag(Tag tag) {
        Tag tag1 = tagRepository.save(tag);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tag1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Tag> getTagById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            Tag tag2 = optionalTag.get();
            return new ResponseEntity<>(tag2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tags, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tag> updateTag(Tag tag) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Tag> optionalTag = tagRepository.findById(tag.getId());
        if (optionalTag.isPresent()) {
            Tag tag1 = optionalTag.get();
            BeanUtils.copyProperties(tag, tag1);
            tagRepository.save(tag1);
            return new ResponseEntity<>(tag1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteTag(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            tagRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No tag found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Tag deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
