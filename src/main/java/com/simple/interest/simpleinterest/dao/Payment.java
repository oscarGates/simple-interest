package com.simple.interest.simpleinterest.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer paymentNumber;
    private Double amount;
    private Date paymentDate;
}
