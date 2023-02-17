package com.mohibur.problem_solving.repository;

import com.mohibur.problem_solving.entity.Hint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HintRepository extends JpaRepository<Hint, Long> {

}
