package com.mohibur.problem_solving.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mohibur.common.entity.BaseModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "problem")
public class Problem extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(length = 10000)
    private String description;

    private Integer problemNo;
    private Integer submissionsCount;
    private Integer acceptedCount;
    private String difficulty;
    private Integer frequency;
    private Integer likesCount;
    private Integer dislikesCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
    private List<Example> exampleList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
    private List<Constraint> constraintList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
    private List<Submission> submissionList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problemList")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
    private List<Topic> topicList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
    private List<Hint> hintList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
    private List<Solution> solutionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @JsonIgnoreProperties("problem")
    @ToString.Exclude
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
