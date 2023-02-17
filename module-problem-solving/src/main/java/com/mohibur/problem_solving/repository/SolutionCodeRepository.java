package com.mohibur.problem_solving.repository;

import com.mohibur.problem_solving.entity.SolutionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionCodeRepository extends JpaRepository<SolutionCode, Long> {

}
