package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.entity.Discuss;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DiscussService {
    ResponseEntity<Discuss> createDiscuss(Discuss discuss);

    ResponseEntity<Discuss> getDiscussById(Long id);

    ResponseEntity<List<Discuss>> getAllDiscusses();

    ResponseEntity<Discuss> updateDiscuss(Discuss discuss);

    ResponseEntity<?> deleteDiscuss(Long id);
}
