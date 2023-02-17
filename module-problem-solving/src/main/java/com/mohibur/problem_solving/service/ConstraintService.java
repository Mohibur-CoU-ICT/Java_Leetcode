package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.entity.Constraint;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ConstraintService {
    ResponseEntity<Constraint> createConstraint(Constraint constraint);

    ResponseEntity<Constraint> getConstraintById(Long id);

    ResponseEntity<List<Constraint>> getAllConstraints();

    ResponseEntity<Constraint> updateConstraint(Constraint constraint);

    ResponseEntity<?> deleteConstraint(Long id);
}
