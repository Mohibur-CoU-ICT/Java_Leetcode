package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Solution;
import com.mohibur.leetcode.serviceImpl.SolutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    private SolutionServiceImpl solutionService;

    @PostMapping
    public ResponseEntity<Solution> createSolution(@RequestBody Solution solution) {
        return solutionService.createSolution(solution);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solution> getSolution(@PathVariable Long id) {
        return solutionService.getSolutionById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Solution>> getAllSolutions() {
        return solutionService.getAllSolutions();
    }

    @PutMapping
    public ResponseEntity<Solution> updateSolution(@RequestBody Solution solution) {
        return solutionService.updateSolution(solution);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSolution(@PathVariable Long id) {
        return solutionService.deleteSolution(id);
    }
}
