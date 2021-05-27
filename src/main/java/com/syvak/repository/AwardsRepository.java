package com.syvak.repository;

import com.syvak.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardsRepository extends JpaRepository<Award, Integer> {}
