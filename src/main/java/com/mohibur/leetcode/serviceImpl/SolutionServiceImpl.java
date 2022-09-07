package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Solution;
import com.mohibur.leetcode.repository.SolutionRepository;
import com.mohibur.leetcode.service.SolutionService;
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
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;

    @Override
    public ResponseEntity<Solution> createSolution(Solution solution) {
        Solution solution1 = solutionRepository.save(solution);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(solution1, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Solution> getSolutionById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Solution> optionalSolution = solutionRepository.findById(id);
        if (optionalSolution.isPresent()) {
            Solution solution2 = optionalSolution.get();
            return new ResponseEntity<>(solution2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Solution>> getAllSolutions() {
        List<Solution> solutions = solutionRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(solutions, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Solution> updateSolution(Solution solution) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Solution> optionalSolution = solutionRepository.findById(solution.getId());
        if (optionalSolution.isPresent()) {
            Solution solution1 = optionalSolution.get();
            BeanUtils.copyProperties(solution, solution1);
            solutionRepository.save(solution1);
            return new ResponseEntity<>(solution1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteSolution(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            solutionRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No solution found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Solution deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
