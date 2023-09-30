package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Problem;
import com.mohibur.leetcode.repository.ProblemRepository;
import com.mohibur.leetcode.service.ProblemService;
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
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public ResponseEntity<Problem> createProblem(Problem problem) {
        Problem problem1 = problemRepository.save(problem);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(problem1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Problem> getProblemById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Problem> optionalProblem = problemRepository.findById(id);
        if (optionalProblem.isPresent()) {
            Problem problem2 = optionalProblem.get();
            return new ResponseEntity<>(problem2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Problem>> getAllProblems() {
        List<Problem> problems = problemRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(problems, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Problem> updateProblem(Problem problem) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Problem> optionalProblem = problemRepository.findById(problem.getId());
        if (optionalProblem.isPresent()) {
            Problem problem1 = optionalProblem.get();
            BeanUtils.copyProperties(problem, problem1);
            problemRepository.save(problem1);
            return new ResponseEntity<>(problem1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteProblem(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            problemRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No problem found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Problem deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
