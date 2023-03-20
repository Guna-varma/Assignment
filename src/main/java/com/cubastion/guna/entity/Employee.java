package com.cubastion.guna.entity;

import com.cubastion.guna.Utils.KEYS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {


    @Id
    @Column(name = "Ssn", length = 9)
    private String ssn;


    @Column(name = "Fname",length = 15)
    @NotNull
    private String fname;

    @Column(name = "Minit",length = 1)
    private String minit;

    @Column(name = "Lname",length = 15)
    @NotNull
    private String lname;

    @Column(name = "Bdate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = KEYS.DATE_FORMAT)
    private String bdate;

    @Column(name = "Address",length = 50)
    private String address;

    @Column(name = "Sex", length = 1)
    private String sex;

    @Column(name = "Salary")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "1000000000.00")
    private Double salary;

    @Column(name = "Super_ssn",length = 9)
    private String superssn;

    @Column(name = "Dno")
    private Integer dno;


//    @ManyToOne
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
//    @JoinColumn(name = "Dno", insertable = false,updatable = false)
//    private Department departments;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "employees",orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<Dependent> dependentList;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    private List<WorksOn> worksOnList;
//
//    @JsonIgnore
//    @OneToOne(mappedBy ="employeeSsn" ,cascade = CascadeType.ALL)
//    private Department dept;


//    @JsonIgnore
//    @OneToMany(mappedBy = "superid",orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<Employee> employeesParent;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Super_ssn",nullable = false,updatable = false)
//    private Employee superid;

}