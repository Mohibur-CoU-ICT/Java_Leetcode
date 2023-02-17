package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.entity.Submission;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SubmissionService {
    ResponseEntity<Submission> createSubmission(Submission submission);

    ResponseEntity<Submission> getSubmissionById(Long id);

    ResponseEntity<List<Submission>> getAllSubmissions();

    ResponseEntity<Submission> updateSubmission(Submission submission);

    ResponseEntity<?> deleteSubmission(Long id);
}
