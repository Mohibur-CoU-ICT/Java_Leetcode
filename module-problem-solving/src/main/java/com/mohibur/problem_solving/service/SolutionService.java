package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.entity.Solution;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SolutionService {
    ResponseEntity<Solution> createSolution(Solution solution);

    ResponseEntity<Solution> getSolutionById(Long id);

    ResponseEntity<List<Solution>> getAllSolutions();

    ResponseEntity<Solution> updateSolution(Solution solution);

    ResponseEntity<?> deleteSolution(Long id);
}
