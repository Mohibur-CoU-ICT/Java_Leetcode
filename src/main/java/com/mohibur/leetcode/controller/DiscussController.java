package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Discuss;
import com.mohibur.leetcode.interfaces.UrlConstant;
import com.mohibur.leetcode.serviceImpl.DiscussServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.DiscussUrl.ROOT)
public class DiscussController {
    @Autowired
    private DiscussServiceImpl discussService;

    @PostMapping
    public ResponseEntity<Discuss> createDiscuss(@RequestBody Discuss discuss) {
        return discussService.createDiscuss(discuss);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Discuss> getDiscuss(@PathVariable Long id) {
        return discussService.getDiscussById(id);
    }

    @GetMapping
    public ResponseEntity<List<Discuss>> getAllDiscusses() {
        return discussService.getAllDiscusses();
    }

    @PutMapping
    public ResponseEntity<Discuss> updateDiscuss(@RequestBody Discuss discuss) {
        return discussService.updateDiscuss(discuss);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteDiscuss(@PathVariable Long id) {
        return discussService.deleteDiscuss(id);
    }
}
