package com.mohibur.discussion.controller;

import com.mohibur.discussion.entity.Comment;
import com.mohibur.discussion.serviceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
