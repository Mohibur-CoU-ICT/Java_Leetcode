package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Discuss;
import com.mohibur.leetcode.repository.DiscussRepository;
import com.mohibur.leetcode.service.DiscussService;
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
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussRepository discussRepository;

    @Override
    public ResponseEntity<Discuss> createDiscuss(Discuss discuss) {
        Discuss discuss1 = discussRepository.save(discuss);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(discuss1, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Discuss> getDiscussById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Discuss> optionalDiscuss = discussRepository.findById(id);
        if (optionalDiscuss.isPresent()) {
            Discuss discuss = optionalDiscuss.get();
            return new ResponseEntity<>(discuss, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Discuss>> getAllDiscusses() {
        List<Discuss> problems = discussRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(problems, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Discuss> updateDiscuss(Discuss discuss) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Discuss> optionalDiscuss = discussRepository.findById(discuss.getId());
        if (optionalDiscuss.isPresent()) {
            Discuss discuss1 = optionalDiscuss.get();
            BeanUtils.copyProperties(discuss, discuss1);
            discussRepository.save(discuss1);
            return new ResponseEntity<>(discuss1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteDiscuss(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            discussRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No discuss found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Discuss deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
