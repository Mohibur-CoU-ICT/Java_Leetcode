package com.mohibur.leetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "discuss")
public class Discuss extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discussed_by_id")
    private User discussedBy;

    @Column(name = "text", length = 10000)
    private String text;

    private String title;
    private Integer views;
    private Integer upvote;
    private Integer downvote;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discuss")
    @ToString.Exclude
    private List<Comment> commentList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "discussList")
    @JsonIgnoreProperties({"discussList"})
    @ToString.Exclude
    private List<Tag> tagList;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    @JsonIgnoreProperties({"problemNo", "title", "description", "submissionsCount", "accepted", "difficulty", "frequency", "likesCount", "dislikesCount", "exampleList", "constraintList", "submissionList", "topicList", "hintList", "solutionList", "discussList"})
    private Problem problem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Discuss discuss = (Discuss) o;
        return id != null && Objects.equals(id, discuss.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
