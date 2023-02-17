package com.mohibur.problem_solving.service;

import com.mohibur.problem_solving.interfaces.TopicWiseProblemCount;
import com.mohibur.problem_solving.entity.Topic;
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
