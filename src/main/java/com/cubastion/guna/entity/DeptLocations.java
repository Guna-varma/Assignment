package com.cubastion.guna.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "DEPT_LOCATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeptLocations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Dnumber")
    private Integer dnumber;

    @Column(name = "Dlocation",length = 15)
    private String dlocation;

//    @OneToOne
//    @JoinColumn(name = "Dnumber",insertable = false,updatable = false)
//    private Department deptNumber;

}