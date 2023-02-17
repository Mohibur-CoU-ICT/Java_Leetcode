package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.entity.Problem;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProblemService {
    ResponseEntity<Problem> createProblem(Problem problem);

    ResponseEntity<Problem> getProblemById(Long id);

    ResponseEntity<List<Problem>> getAllProblems();

    ResponseEntity<Problem> updateProblem(Problem problem);

    ResponseEntity<?> deleteProblem(Long id);
}
