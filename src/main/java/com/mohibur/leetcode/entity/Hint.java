package com.mohibur.leetcode.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "hint")
public class Hint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hint;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Hint hint = (Hint) o;
        return id != null && Objects.equals(id, hint.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
