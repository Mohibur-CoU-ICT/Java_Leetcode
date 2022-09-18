package com.mohibur.leetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "example")
public class Example implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String input;
    private String output;
    private String explanation;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    @JsonIgnoreProperties({"problemNo", "title", "description", "submissionsCount", "accepted", "difficulty", "frequency", "likesCount", "dislikesCount", "exampleList", "constraintList", "submissionList", "topicList", "hintList", "solutionList", "discussList"})
    private Problem problem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Example pExample = (Example) o;
        return id != null && Objects.equals(id, pExample.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
