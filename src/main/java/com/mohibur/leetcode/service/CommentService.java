package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CommentService {
    ResponseEntity<Comment> createComment(Comment comment);
    ResponseEntity<Comment> getCommentById(Long id);
    ResponseEntity<List<Comment>> getAllComments();
    ResponseEntity<Comment> updateComment(Comment comment);
    ResponseEntity<?> deleteComment(Long id);
}
