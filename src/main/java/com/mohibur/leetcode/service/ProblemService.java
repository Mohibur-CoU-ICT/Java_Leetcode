package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.Problem;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProblemService {
    ResponseEntity<Problem> createProblem(Problem problem);
    ResponseEntity<Problem> getProblemById(Long id);
    ResponseEntity<List<Problem>> getAllProblems();
    ResponseEntity<Problem> updateProblem(Problem problem);
    ResponseEntity deleteProblem(Long id);
}
