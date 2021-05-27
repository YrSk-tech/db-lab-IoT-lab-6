package com.syvak.repository;

import com.syvak.domain.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountsRepository extends JpaRepository<Discounts, Integer> {
}
