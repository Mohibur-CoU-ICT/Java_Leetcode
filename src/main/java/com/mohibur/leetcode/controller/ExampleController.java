package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Example;
import com.mohibur.leetcode.serviceImpl.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private ExampleServiceImpl exampleService;

    @PostMapping
    public ResponseEntity<Example> createExample(@RequestBody Example example) {
        return exampleService.createExample(example);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Example> getExample(@PathVariable Long id) {
        return exampleService.getExampleById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Example>> getAllExamples() {
        return exampleService.getAllExamples();
    }

    @PutMapping
    public ResponseEntity<Example> updateExample(@RequestBody Example example) {
        return exampleService.updateExample(example);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExample(@PathVariable Long id) {
        return exampleService.deleteExample(id);
    }
}
