package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Topic;
import com.mohibur.leetcode.interfaces.TopicWiseProblemCount;
import com.mohibur.leetcode.interfaces.UrlConstant;
import com.mohibur.leetcode.serviceImpl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.TopicUrl.ROOT)
public class TopicController {
    @Autowired
    private TopicServiceImpl topicService;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Topic> getTopic(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping(UrlConstant.TopicUrl.TOPIC_WISE_PROBLEM_COUNT)
    public ResponseEntity<List<TopicWiseProblemCount>> getTopicWiseProblemCount() {
        return topicService.getTopicWiseProblemCount();
    }

    @PutMapping
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {
        return topicService.updateTopic(topic);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        return topicService.deleteTopic(id);
    }
}
