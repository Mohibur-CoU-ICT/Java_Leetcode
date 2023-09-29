package com.mohibur.problem_solving.controller;

import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.problem_solving.entity.Comment;
import com.mohibur.problem_solving.serviceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.CommentUrl.ROOT)
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
