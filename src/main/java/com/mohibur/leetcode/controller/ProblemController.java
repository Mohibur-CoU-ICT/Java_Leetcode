package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Problem;
import com.mohibur.leetcode.serviceImpl.ProblemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemServiceImpl problemService;

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
        return problemService.createProblem(problem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblem(@PathVariable Long id) {
        return problemService.getProblemById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Problem>> getAllProblems() {
        return problemService.getAllProblems();
    }

    @PutMapping
    public ResponseEntity<Problem> updateProblem(@RequestBody Problem problem) {
        return problemService.updateProblem(problem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProblem(@PathVariable Long id) {
        return problemService.deleteProblem(id);
    }
}
