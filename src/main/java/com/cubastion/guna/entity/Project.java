package com.cubastion.guna.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "PROJECT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Pnumber")
    private Integer pnumber;

    @Column(name = "Pname",length = 25)
    @NotNull
    private String pname;

    @Column(name = "Plocation",length = 15)
    private String plocation;

    @Column(name = "Dnum")
    private Integer dnum;

//    @ManyToOne
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
//    @JoinColumn(name = "Dnum",insertable = false,updatable = false)
//    private Department departments;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<WorksOn> worksOnList;

}