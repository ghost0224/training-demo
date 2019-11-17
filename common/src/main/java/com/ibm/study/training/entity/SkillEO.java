package com.ibm.study.training.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skill")
public class SkillEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

}
