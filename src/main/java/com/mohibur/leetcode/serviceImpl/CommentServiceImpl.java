package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Comment;
import com.mohibur.leetcode.repository.CommentRepository;
import com.mohibur.leetcode.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ResponseEntity<Comment> createComment(Comment comment) {
        Comment comment1 = commentRepository.save(comment);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(comment1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Comment> getCommentById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment2 = optionalComment.get();
            return new ResponseEntity<>(comment2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> problems = commentRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(problems, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Comment> updateComment(Comment comment) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Comment> optionalComment = commentRepository.findById(comment.getId());
        if (optionalComment.isPresent()) {
            Comment comment1 = optionalComment.get();
            BeanUtils.copyProperties(comment, comment1);
            commentRepository.save(comment1);
            return new ResponseEntity<>(comment1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteComment(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No comment found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Comment deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
