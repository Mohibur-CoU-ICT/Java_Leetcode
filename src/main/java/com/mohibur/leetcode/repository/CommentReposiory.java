package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentReposiory extends JpaRepository<Comment, Long> {

}
