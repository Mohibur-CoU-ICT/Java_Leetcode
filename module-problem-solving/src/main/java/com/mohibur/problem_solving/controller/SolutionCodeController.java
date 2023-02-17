package com.mohibur.problem_solving.controller;

import com.mohibur.problem_solving.serviceImpl.SolutionCodeServiceImpl;
import com.mohibur.problem_solving.entity.SolutionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solutionCode")
public class SolutionCodeController {
    @Autowired
    private SolutionCodeServiceImpl solutionCodeService;

    @PostMapping
    public ResponseEntity<SolutionCode> createSolutionCode(@RequestBody SolutionCode solutionCode) {
        return solutionCodeService.createSolutionCode(solutionCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolutionCode> getSolutionCode(@PathVariable Long id) {
        return solutionCodeService.getSolutionCodeById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SolutionCode>> getAllSolutionCodes() {
        return solutionCodeService.getAllSolutionCodes();
    }

    @PutMapping
    public ResponseEntity<SolutionCode> updateSolutionCode(@RequestBody SolutionCode solutionCode) {
        return solutionCodeService.updateSolutionCode(solutionCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSolutionCode(@PathVariable Long id) {
        return solutionCodeService.deleteSolutionCode(id);
    }
}
