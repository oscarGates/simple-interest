package com.simple.interest.simpleinterest.controller;

import com.simple.interest.simpleinterest.dtos.Data;
import com.simple.interest.simpleinterest.dtos.Payment;
import com.simple.interest.simpleinterest.services.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CalculatorController {
    private final PaymentsService paymentsService;
    @PostMapping(value = "/payments")
    public ResponseEntity<List<Payment>> getPayments(@RequestBody Data body){
            return paymentsService.processDataToPayments(body);
    }
}
