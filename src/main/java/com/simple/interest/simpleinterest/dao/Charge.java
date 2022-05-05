package com.simple.interest.simpleinterest.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "charges")
@Data
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private Integer terms;
    private Double rate;
}
