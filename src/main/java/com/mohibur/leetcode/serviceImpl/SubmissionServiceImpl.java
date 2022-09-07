package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Submission;
import com.mohibur.leetcode.repository.SubmissionRepository;
import com.mohibur.leetcode.service.SubmissionService;
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
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public ResponseEntity<Submission> createSubmission(Submission submission) {
        Submission submission1 = submissionRepository.save(submission);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(submission1, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Submission> getSubmissionById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Submission> optionalSubmission = submissionRepository.findById(id);
        if (optionalSubmission.isPresent()) {
            Submission submission2 = optionalSubmission.get();
            return new ResponseEntity<>(submission2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        List<Submission> submissions = submissionRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(submissions, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Submission> updateSubmission(Submission submission) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Submission> optionalSubmission = submissionRepository.findById(submission.getId());
        if (optionalSubmission.isPresent()) {
            Submission submission1 = optionalSubmission.get();
            BeanUtils.copyProperties(submission, submission1);
            submissionRepository.save(submission1);
            return new ResponseEntity<>(submission1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteSubmission(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            submissionRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No submission found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Submission deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
