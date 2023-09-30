package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussRepository extends JpaRepository<Discuss, Long> {

}
