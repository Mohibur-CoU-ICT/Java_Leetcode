package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.Hint;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface HintService {
    ResponseEntity<Hint> createHint(Hint hint);

    ResponseEntity<Hint> getHintById(Long id);

    ResponseEntity<List<Hint>> getAllHints();

    ResponseEntity<Hint> updateHint(Hint hint);

    ResponseEntity<?> deleteHint(Long id);
}
