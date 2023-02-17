package com.mohibur.problem_solving.controller;

import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.problem_solving.serviceImpl.ExampleServiceImpl;
import com.mohibur.problem_solving.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.ExampleUrl.ROOT)
public class ExampleController {
    @Autowired
    private ExampleServiceImpl exampleService;

    @PostMapping
    public ResponseEntity<Example> createExample(@RequestBody Example example) {
        return exampleService.createExample(example);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Example> getExample(@PathVariable Long id) {
        return exampleService.getExampleById(id);
    }

    @GetMapping
    public ResponseEntity<List<Example>> getAllExamples() {
        return exampleService.getAllExamples();
    }

    @PutMapping
    public ResponseEntity<Example> updateExample(@RequestBody Example example) {
        return exampleService.updateExample(example);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteExample(@PathVariable Long id) {
        return exampleService.deleteExample(id);
    }
}
