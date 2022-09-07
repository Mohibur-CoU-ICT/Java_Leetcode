package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Hint;
import com.mohibur.leetcode.repository.HintRepository;
import com.mohibur.leetcode.service.HintService;
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
public class HintServiceImpl implements HintService {

    @Autowired
    private HintRepository hintRepository;

    @Override
    public ResponseEntity<Hint> createHint(Hint hint) {
        Hint hint1 = hintRepository.save(hint);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(hint1, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hint> getHintById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Hint> optionalHint = hintRepository.findById(id);
        if (optionalHint.isPresent()) {
            Hint hint2 = optionalHint.get();
            return new ResponseEntity<>(hint2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Hint>> getAllHints() {
        List<Hint> hints = hintRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(hints, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hint> updateHint(Hint hint) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Hint> optionalHint = hintRepository.findById(hint.getId());
        if (optionalHint.isPresent()) {
            Hint hint1 = optionalHint.get();
            BeanUtils.copyProperties(hint, hint1);
            hintRepository.save(hint1);
            return new ResponseEntity<>(hint1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteHint(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            hintRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No hint found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Hint deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
