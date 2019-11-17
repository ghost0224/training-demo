package com.ibm.study.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "id"))
    private RoleEO role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_training", joinColumns ={@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name="training_id")})
    private List<TrainingEO> trainingList;

    @Transient
    private List<PaymentEO> paymentList;

}
