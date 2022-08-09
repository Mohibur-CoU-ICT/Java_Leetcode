package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicReposiory extends JpaRepository<Topic, Long> {
    
}
