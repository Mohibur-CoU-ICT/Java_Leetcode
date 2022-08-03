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
@Table(name = "solution")
public class Solution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "solution")
    @ToString.Exclude
    private List<SolutionCode> solutionCodes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Solution pSolution = (Solution) o;
        return id != null && Objects.equals(id, pSolution.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
