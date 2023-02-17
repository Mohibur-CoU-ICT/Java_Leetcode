package com.mohibur.problem_solving.controller;

import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.problem_solving.serviceImpl.ConstraintServiceImpl;
import com.mohibur.problem_solving.entity.Constraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.ConstraintUrl.ROOT)
public class ConstraintController {
    @Autowired
    private ConstraintServiceImpl constraintService;

    @PostMapping
    public ResponseEntity<Constraint> createConstraint(@RequestBody Constraint constraint) {
        return constraintService.createConstraint(constraint);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Constraint> getConstraint(@PathVariable Long id) {
        return constraintService.getConstraintById(id);
    }

    @GetMapping
    public ResponseEntity<List<Constraint>> getAllConstraints() {
        return constraintService.getAllConstraints();
    }

    @PutMapping
    public ResponseEntity<Constraint> updateConstraint(@RequestBody Constraint constraint) {
        return constraintService.updateConstraint(constraint);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteConstraint(@PathVariable Long id) {
        return constraintService.deleteConstraint(id);
    }
}
