package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.interfaces.TopicWiseProblemCount;
import com.mohibur.leetcode.entity.Topic;
import com.mohibur.leetcode.serviceImpl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicServiceImpl topicService;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Topic>> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/getTopicWiseProblemCount")
    public ResponseEntity<List<TopicWiseProblemCount>> getTopicWiseProblemCount() {
        return topicService.getTopicWiseProblemCount();
    }

    @PutMapping
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {
        return topicService.updateTopic(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        return topicService.deleteTopic(id);
    }
}
