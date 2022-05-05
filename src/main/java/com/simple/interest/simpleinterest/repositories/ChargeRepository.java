package com.simple.interest.simpleinterest.repositories;

import com.simple.interest.simpleinterest.dao.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {
}
