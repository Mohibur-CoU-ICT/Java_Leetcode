package com.mohibur.leetcode.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "discuss")
public class Discuss implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discussed_by_id")
    private User discussedBy;

    private String discussTitle;
    private String discussDescription;
    private Calendar discussAt;
    private Integer views;
    private Integer upvote;
    private Integer downvote;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discuss")
    @ToString.Exclude
    private List<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "discusses")
    @ToString.Exclude
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "problem_id")
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
