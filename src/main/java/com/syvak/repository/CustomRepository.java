package com.syvak.repository;

import com.syvak.domain.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository extends JpaRepository<Custom, Integer> {
}
