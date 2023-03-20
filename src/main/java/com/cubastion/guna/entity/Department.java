package com.cubastion.guna.entity;

import com.cubastion.guna.Utils.KEYS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "DEPARTMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotNull
    @Column(name = "Dnumber")
    private Integer dnumber;


    @Column(length = 25, name = "Dname"
//            , unique = true
    )
    @NotNull
    private String dname;

    @NotNull
    @Column(name = "Mgr_ssn", length = 9)
    private String mgrssn;

    @Column(name = "Mgr_start_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = KEYS.DATE_FORMAT)
    private String mgrstartdate;

//    @JsonIgnore
//    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
//    private List<Employee> employeeList;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
//    private List<Project> projectList;
//
//    @OneToOne
//    @JoinColumn(name = "Mgr_ssn",insertable = false,updatable = false)
//    private Employee employeeSsn;
//
//
//    @OneToOne(mappedBy = "deptNumber",cascade = CascadeType.ALL)
//    private DeptLocations locations;

}