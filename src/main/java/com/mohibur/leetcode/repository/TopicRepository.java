package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.dto.TopicWiseProblemCount;
import com.mohibur.leetcode.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query(value = "select t.id, t.name, count(tp.problem_id) as problemCount \n" +
            "from topic t left join topic_problem tp \n" +
            "on tp.topic_id = t.id \n" +
            "group by t.name \n" +
            "order by problemCount desc ", nativeQuery = true)
    public List<TopicWiseProblemCount> getTopicWiseProblemCount();
}
