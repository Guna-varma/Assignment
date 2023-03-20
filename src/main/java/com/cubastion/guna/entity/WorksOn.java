package com.cubastion.guna.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity(name = "WORKS_ON")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class WorksOn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Essn",length = 9)
    private String essn;

    @Column(name = "Pno")
    private Integer pno;

    @Column(name = "Hours")
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "9999.00")
    private Double hours;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Essn",insertable = false,updatable = false)
//    private Employee employee;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Pno", insertable = false,updatable = false)
//    private Project project;

}