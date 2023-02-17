package com.mohibur.discussion.repository;

import com.mohibur.discussion.entity.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussRepository extends JpaRepository<Discuss, Long> {

}
