package com.simple.interest.simpleinterest.services;

import com.simple.interest.simpleinterest.dtos.Data;
import com.simple.interest.simpleinterest.dtos.Payment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentsService {
    ResponseEntity<List<Payment>> processDataToPayments(Data body);
}
