package com.mohibur.problem_solving.repository;

import com.mohibur.problem_solving.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {
    
}
