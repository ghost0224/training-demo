package com.ibm.study.training.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TrainingDTO {

    private Long id;

    private String title;

    private Float fees = 0.0F;

    private Integer rating = 0;

    private Date startDate;

    private Date endDate;

    private Date startTime;

    private Date endTime;

    private SkillDTO skill;

    private boolean book;

}
