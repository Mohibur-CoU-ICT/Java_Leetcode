package com.mohibur.problem_solving.serviceImpl;

import com.mohibur.problem_solving.entity.Example;
import com.mohibur.problem_solving.repository.ExampleRepository;
import com.mohibur.problem_solving.service.ExampleService;
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
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public ResponseEntity<Example> createExample(Example example) {
        Example example1 = exampleRepository.save(example);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(example1, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Example> getExampleById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (optionalExample.isPresent()) {
            Example example2 = optionalExample.get();
            return new ResponseEntity<>(example2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Example>> getAllExamples() {
        List<Example> examples = exampleRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(examples, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Example> updateExample(Example example) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Example> optionalExample = exampleRepository.findById(example.getId());
        if (optionalExample.isPresent()) {
            Example example1 = optionalExample.get();
            BeanUtils.copyProperties(example, example1);
            exampleRepository.save(example1);
            return new ResponseEntity<>(example1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteExample(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            exampleRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No example found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Example deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
