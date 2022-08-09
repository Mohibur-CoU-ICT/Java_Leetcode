package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiory extends JpaRepository<User, Long> {
    
}
