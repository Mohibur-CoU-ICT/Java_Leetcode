package com.mohibur.leetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mohibur.leetcode.enums.SolutionLanguage;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "solution_code")
public class SolutionCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SolutionLanguage solutionLanguage;

    @Column(name = "solution_code", length = 10000)
    private String solutionCode;

    @ManyToOne
    @JoinColumn(name = "solution_id")
    @JsonIgnoreProperties({"problem", "solutionCodes"})
    private Solution solution;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SolutionCode that = (SolutionCode) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
