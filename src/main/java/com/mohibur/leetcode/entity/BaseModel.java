package com.mohibur.leetcode.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @LastModifiedBy
    private String modifiedBy;
}
