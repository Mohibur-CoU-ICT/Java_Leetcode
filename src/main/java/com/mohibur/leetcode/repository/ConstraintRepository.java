package com.mohibur.leetcode.repository;

import com.mohibur.leetcode.entity.Constraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintRepository extends JpaRepository<Constraint, Long> {

}
