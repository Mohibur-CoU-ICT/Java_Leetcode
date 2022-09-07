package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Hint;
import com.mohibur.leetcode.serviceImpl.HintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hint")
public class HintController {
    @Autowired
    private HintServiceImpl hintService;

    @PostMapping
    public ResponseEntity<Hint> createHint(@RequestBody Hint hint) {
        return hintService.createHint(hint);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hint> getHint(@PathVariable Long id) {
        return hintService.getHintById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hint>> getAllHints() {
        return hintService.getAllHints();
    }

    @PutMapping
    public ResponseEntity<Hint> updateHint(@RequestBody Hint hint) {
        return hintService.updateHint(hint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHint(@PathVariable Long id) {
        return hintService.deleteHint(id);
    }
}
