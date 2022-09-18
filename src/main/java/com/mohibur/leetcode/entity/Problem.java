package com.mohibur.leetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Table(name = "problem")
public class Problem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer problemNo;
    @Column(unique = true)
    private String title;
    private String description;
    private Integer submissionsCount;
    private Integer accepted;
    private String difficulty;
    private Integer frequency;
    private Integer likesCount;
    private Integer dislikesCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Example> exampleList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Constraint> constraintList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Submission> submissionList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problems")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Topic> topicList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Hint> hintList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Solution> solutionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    @JsonIgnoreProperties("problem")
    private List<Discuss> discussList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Problem problem = (Problem) o;
        return id != null && Objects.equals(id, problem.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
