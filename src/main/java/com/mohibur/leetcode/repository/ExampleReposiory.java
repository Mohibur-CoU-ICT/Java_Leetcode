package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleReposiory extends JpaRepository<Example, Long> {
    
}
