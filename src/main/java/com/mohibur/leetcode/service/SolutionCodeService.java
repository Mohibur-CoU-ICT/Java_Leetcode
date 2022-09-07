package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.SolutionCode;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SolutionCodeService {
    ResponseEntity<SolutionCode> createSolutionCode(SolutionCode solutionCode);

    ResponseEntity<SolutionCode> getSolutionCodeById(Long id);

    ResponseEntity<List<SolutionCode>> getAllSolutionCodes();

    ResponseEntity<SolutionCode> updateSolutionCode(SolutionCode solutionCode);

    ResponseEntity<?> deleteSolutionCode(Long id);
}
