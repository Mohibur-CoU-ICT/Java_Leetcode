package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.entity.SolutionCode;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SolutionCodeService {
    ResponseEntity<SolutionCode> createSolutionCode(SolutionCode solutionCode);

    ResponseEntity<SolutionCode> getSolutionCodeById(Long id);

    ResponseEntity<List<SolutionCode>> getAllSolutionCodes();

    ResponseEntity<SolutionCode> updateSolutionCode(SolutionCode solutionCode);

    ResponseEntity<?> deleteSolutionCode(Long id);
}
