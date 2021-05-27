package com.syvak.repository;

import com.syvak.domain.Animator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatorRepository extends JpaRepository<Animator, Integer> {
}
