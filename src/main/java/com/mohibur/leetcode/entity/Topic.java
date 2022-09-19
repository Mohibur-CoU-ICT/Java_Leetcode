package com.mohibur.leetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "topic")
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "topic_problem", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "problem_id"))
    @ToString.Exclude
    @JsonIgnoreProperties({"problemNo", "title", "description", "submissionsCount", "accepted", "difficulty", "frequency", "likesCount", "dislikesCount", "exampleList", "constraintList", "submissionList", "topicList", "hintList", "solutionList", "discussList"})
    private List<Problem> problemList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Topic topics = (Topic) o;
        return id != null && Objects.equals(id, topics.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
