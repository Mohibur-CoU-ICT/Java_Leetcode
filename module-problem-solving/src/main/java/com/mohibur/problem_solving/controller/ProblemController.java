package com.mohibur.problem_solving.controller;

import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.problem_solving.serviceImpl.ProblemServiceImpl;
import com.mohibur.problem_solving.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.ProblemUrl.ROOT)
public class ProblemController {
    @Autowired
    private ProblemServiceImpl problemService;

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
        return problemService.createProblem(problem);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Problem> getProblem(@PathVariable Long id) {
        return problemService.getProblemById(id);
    }

    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblems() {
        return problemService.getAllProblems();
    }

    @PutMapping
    public ResponseEntity<Problem> updateProblem(@RequestBody Problem problem) {
        return problemService.updateProblem(problem);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProblem(@PathVariable Long id) {
        return problemService.deleteProblem(id);
    }
}
