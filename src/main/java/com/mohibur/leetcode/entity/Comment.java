package com.mohibur.leetcode.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String commentString;
    private Calendar commentAt;
    private Integer upvote;
    private Integer downvote;

    @OneToOne
    @JoinColumn(name = "comment_by_user_id")
    private User commentBy;

    @ManyToOne
    @JoinColumn(name = "discuss_id")
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
