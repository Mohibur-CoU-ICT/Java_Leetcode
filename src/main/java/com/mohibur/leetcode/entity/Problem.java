package com.mohibur.leetcode.entity;

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
@Table(name = "problem")
public class Problem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer problemNo;
    private String title;
    private String description;
    private Integer submission;
    private Integer accepted;
    private String difficulty;
    private Integer frequency;
    private Integer likesCount;
    private Integer dislikesCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    private List<Example> examples;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "problem")
    private List<Constraint> constraintData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    private List<Submission> submissions;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problems")
    @ToString.Exclude
    private List<Topic> topics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    private List<Hint> hints;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    private List<Solution> solutions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    @ToString.Exclude
    private List<Discuss> discusses;

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
