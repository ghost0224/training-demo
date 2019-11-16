package com.ibm.study.training.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.ibm.study")
@EnableJpaRepositories(basePackages = "com.ibm.study.training.dao")
@EntityScan(basePackages = "com.ibm.study.training.entity")
@EnableTransactionManagement
public class CommonStarter {

    public static void main(String[] args) {
        SpringApplication.run(CommonStarter.class, args);
    }

}
