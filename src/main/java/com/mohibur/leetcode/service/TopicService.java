package com.mohibur.leetcode.service;

import com.mohibur.leetcode.dto.TopicWiseProblemCount;
import com.mohibur.leetcode.entity.Topic;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface TopicService {
    ResponseEntity<Topic> createTopic(Topic topic);

    ResponseEntity<Topic> getTopicById(Long id);

    ResponseEntity<List<Topic>> getAllTopics();

    ResponseEntity<List<TopicWiseProblemCount>> getTopicWiseProblemCount();

    ResponseEntity<Topic> updateTopic(Topic topic);

    ResponseEntity<?> deleteTopic(Long id);
}
