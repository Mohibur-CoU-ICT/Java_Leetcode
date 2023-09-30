package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Constraint;
import com.mohibur.leetcode.repository.ConstraintRepository;
import com.mohibur.leetcode.service.ConstraintService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstraintServiceImpl implements ConstraintService {

    @Autowired
    private ConstraintRepository constraintRepository;

    @Override
    public ResponseEntity<Constraint> createConstraint(Constraint constraint) {
        Constraint constraint1 = constraintRepository.save(constraint);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(constraint1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Constraint> getConstraintById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Constraint> optionalConstraint = constraintRepository.findById(id);
        if (optionalConstraint.isPresent()) {
            Constraint constraint2 = optionalConstraint.get();
            return new ResponseEntity<>(constraint2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Constraint>> getAllConstraints() {
        List<Constraint> constraints = constraintRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(constraints, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Constraint> updateConstraint(Constraint constraint) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Constraint> optionalConstraint = constraintRepository.findById(constraint.getId());
        if (optionalConstraint.isPresent()) {
            Constraint constraint1 = optionalConstraint.get();
            BeanUtils.copyProperties(constraint, constraint1);
            constraintRepository.save(constraint1);
            return new ResponseEntity<>(constraint1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteConstraint(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            constraintRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No constraint found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Constraint deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
