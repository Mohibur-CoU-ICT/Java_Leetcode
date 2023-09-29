package com.mohibur.problem_solving.repository;

import com.mohibur.problem_solving.entity.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussRepository extends JpaRepository<Discuss, Long> {

}
