package com.mohibur.problem_solving.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProblemDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final Integer problemNo;
    private final Integer submissionsCount;
    private final Integer acceptedCount;
    private final String difficulty;
    private final Integer frequency;
    private final Integer likesCount;
    private final Integer dislikesCount;
}
