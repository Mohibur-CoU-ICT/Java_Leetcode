package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Submission;
import com.mohibur.leetcode.serviceImpl.SubmissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    @Autowired
    private SubmissionServiceImpl submissionService;

    @PostMapping
    public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
        return submissionService.createSubmission(submission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmission(@PathVariable Long id) {
        return submissionService.getSubmissionById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @PutMapping
    public ResponseEntity<Submission> updateSubmission(@RequestBody Submission submission) {
        return submissionService.updateSubmission(submission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubmission(@PathVariable Long id) {
        return submissionService.deleteSubmission(id);
    }
}
