package com.mohibur.leetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "comment")
public class Comment extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10000)
    private String text;

    private Integer upvote;
    private Integer downvote;

    @OneToOne
    @JoinColumn(name = "comment_by_user_id")
    @JsonIgnoreProperties({"password", "email", "roles"})
    private User commentBy;

    @ManyToOne
    @JoinColumn(name = "discuss_id")
    @JsonIgnoreProperties({"discussedBy", "discussTitle", "discussDescription", "views", "upvote", "downvote", "commentList", "tagList", "problem"})
    private Discuss discuss;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Comment dComment = (Comment) o;
        return id != null && Objects.equals(id, dComment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
