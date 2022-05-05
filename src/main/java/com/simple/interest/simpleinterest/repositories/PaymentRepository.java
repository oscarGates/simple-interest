package com.simple.interest.simpleinterest.repositories;

import com.simple.interest.simpleinterest.dao.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
