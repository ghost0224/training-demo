package com.ibm.study.training.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment")
public class PaymentEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float amount;

    @Column
    private String remarks;

    @Column(name = "training_id")
    private String trainingId;

    @Column(name = "training_name")
    private String trainingName;

}
