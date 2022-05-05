package com.simple.interest.simpleinterest.services.impl;

import com.simple.interest.simpleinterest.dao.Charge;
import com.simple.interest.simpleinterest.dtos.Data;
import com.simple.interest.simpleinterest.dtos.Payment;
import com.simple.interest.simpleinterest.repositories.ChargeRepository;
import com.simple.interest.simpleinterest.repositories.PaymentRepository;
import com.simple.interest.simpleinterest.services.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentsServiceImpl implements PaymentsService {
    private final ChargeRepository chargeRepository;
    private final PaymentRepository paymentRepository;
    @Override
    public ResponseEntity<List<Payment>> processDataToPayments(Data body){
        Double totalAmount = body.getAmount() * (1+body.getRate());
        double termAmount = fixTwoDigits(totalAmount / body.getTerms());
        Date today = new Date();
        LocalDate localDate = LocalDate.now();
        Charge charge = new Charge();

        BeanUtils.copyProperties(body, charge);
        chargeRepository.save(charge);
        List<Payment> ans = new ArrayList<>();
        for(int i = 0; i < body.getTerms(); i++){
            ans.add(Payment.builder()
                            .amount(termAmount)
                            .paymentNumber(i+1)
                            .paymentDate(today)
                    .build());
            localDate = localDate.with(TemporalAdjusters.next(localDate.getDayOfWeek()));
            today =  Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            com.simple.interest.simpleinterest.dao.Payment paymentDao = new com.simple.interest.simpleinterest.dao.Payment();
            if(paymentDao != null)
                paymentRepository.save(paymentDao);
            BeanUtils.copyProperties(ans.get(i), paymentDao);

        }

        return ResponseEntity.ok(ans);
    }

    private Double fixTwoDigits(double toFix){
        int aux = (int) (toFix*100);
        return Double.valueOf(aux)/100;
    }
}
