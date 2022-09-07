package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Constraint;
import com.mohibur.leetcode.serviceImpl.ConstraintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/constraint")
public class ConstraintController {
    @Autowired
    private ConstraintServiceImpl constraintService;

    @PostMapping
    public ResponseEntity<Constraint> createConstraint(@RequestBody Constraint constraint) {
        return constraintService.createConstraint(constraint);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Constraint> getConstraint(@PathVariable Long id) {
        return constraintService.getConstraintById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Constraint>> getAllConstraints() {
        return constraintService.getAllConstraints();
    }

    @PutMapping
    public ResponseEntity<Constraint> updateConstraint(@RequestBody Constraint constraint) {
        return constraintService.updateConstraint(constraint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConstraint(@PathVariable Long id) {
        return constraintService.deleteConstraint(id);
    }
}
