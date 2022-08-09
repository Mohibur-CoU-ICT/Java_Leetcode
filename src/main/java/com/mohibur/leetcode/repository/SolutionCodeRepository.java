package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.SolutionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionCodeRepository extends JpaRepository<SolutionCode, Long> {

}
