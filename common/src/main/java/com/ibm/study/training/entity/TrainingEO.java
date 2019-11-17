package com.ibm.study.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "training")
public class TrainingEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="fees", nullable = false)
    private Float fees = 0.0F;

    @Column(name="rating", nullable = false)
    private Integer rating = 0;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="start_time")
    private Date startTime;

    @Column(name="end_time")
    private Date endTime;

    @OneToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private SkillEO skill;

}
