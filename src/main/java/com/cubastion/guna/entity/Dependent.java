package com.cubastion.guna.entity;

import com.cubastion.guna.Utils.KEYS;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "DEPENDENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;


    @Column(length = 9,name = "Essn"
//    ,unique = true,nullable = false
    )
    private String essn;

    @Column(name = "Dependent_name",length = 15)
    private String dependent_name;

    @Column(name = "Sex",length = 1)
    private String sex;

    @Column(name = "Bdate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = KEYS.DATE_FORMAT)
    private String bdate;

    @Column(name = "relationship",length = 8)
    private String relationship;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Essn",insertable = false,updatable = false)
//    private Employee employees;

}
