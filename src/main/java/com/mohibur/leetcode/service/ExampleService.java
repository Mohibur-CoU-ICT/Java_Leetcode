package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.Example;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ExampleService {
    ResponseEntity<Example> createExample(Example example);

    ResponseEntity<Example> getExampleById(Long id);

    ResponseEntity<List<Example>> getAllExamples();

    ResponseEntity<Example> updateExample(Example example);

    ResponseEntity<?> deleteExample(Long id);
}
