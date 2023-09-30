package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.SolutionCode;
import com.mohibur.leetcode.repository.SolutionCodeRepository;
import com.mohibur.leetcode.service.SolutionCodeService;
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
public class SolutionCodeServiceImpl implements SolutionCodeService {

    @Autowired
    private SolutionCodeRepository solutionCodeRepository;

    @Override
    public ResponseEntity<SolutionCode> createSolutionCode(SolutionCode solutionCode) {
        SolutionCode solutionCode1 = solutionCodeRepository.save(solutionCode);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(solutionCode1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SolutionCode> getSolutionCodeById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<SolutionCode> optionalSolutionCode = solutionCodeRepository.findById(id);
        if (optionalSolutionCode.isPresent()) {
            SolutionCode solutionCode2 = optionalSolutionCode.get();
            return new ResponseEntity<>(solutionCode2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<SolutionCode>> getAllSolutionCodes() {
        List<SolutionCode> solutionCodes = solutionCodeRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(solutionCodes, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SolutionCode> updateSolutionCode(SolutionCode solutionCode) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<SolutionCode> optionalSolutionCode = solutionCodeRepository.findById(solutionCode.getId());
        if (optionalSolutionCode.isPresent()) {
            SolutionCode solutionCode1 = optionalSolutionCode.get();
            BeanUtils.copyProperties(solutionCode, solutionCode1);
            solutionCodeRepository.save(solutionCode1);
            return new ResponseEntity<>(solutionCode1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteSolutionCode(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            solutionCodeRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No solutionCode found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("SolutionCode deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
