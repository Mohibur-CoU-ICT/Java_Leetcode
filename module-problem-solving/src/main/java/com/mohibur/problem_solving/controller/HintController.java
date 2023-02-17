package com.mohibur.problem_solving.controller;

import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.problem_solving.serviceImpl.HintServiceImpl;
import com.mohibur.problem_solving.entity.Hint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.HintUrl.ROOT)
public class HintController {
    @Autowired
    private HintServiceImpl hintService;

    @PostMapping
    public ResponseEntity<Hint> createHint(@RequestBody Hint hint) {
        return hintService.createHint(hint);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Hint> getHint(@PathVariable Long id) {
        return hintService.getHintById(id);
    }

    @GetMapping
    public ResponseEntity<List<Hint>> getAllHints() {
        return hintService.getAllHints();
    }

    @PutMapping
    public ResponseEntity<Hint> updateHint(@RequestBody Hint hint) {
        return hintService.updateHint(hint);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteHint(@PathVariable Long id) {
        return hintService.deleteHint(id);
    }
}
