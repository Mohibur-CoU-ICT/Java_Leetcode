package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.Topic;
import com.mohibur.leetcode.interfaces.TopicWiseProblemCount;
import com.mohibur.leetcode.repository.TopicRepository;
import com.mohibur.leetcode.service.TopicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public ResponseEntity<Topic> createTopic(Topic topic) {
        Topic topic1 = topicRepository.save(topic);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(topic1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Topic> getTopicById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic topic2 = optionalTopic.get();
            return new ResponseEntity<>(topic2, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(topics, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TopicWiseProblemCount>> getTopicWiseProblemCount() {
        List<TopicWiseProblemCount> ans = topicRepository.getTopicWiseProblemCount();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(ans, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Topic> updateTopic(Topic topic) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Topic> optionalTopic = topicRepository.findById(topic.getId());
        if (optionalTopic.isPresent()) {
            Topic topic1 = optionalTopic.get();
            BeanUtils.copyProperties(topic, topic1);
            topicRepository.save(topic1);
            return new ResponseEntity<>(topic1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteTopic(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No topic found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Topic deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
