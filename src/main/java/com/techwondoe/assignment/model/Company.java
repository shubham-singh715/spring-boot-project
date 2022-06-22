package com.techwondoe.assignment.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID companyId;

    private String companyName;
    private String companyCEO;
    private String companyAddress;
    private Date inceptionDate;

    @OneToMany(mappedBy = "company")
    private List<Team> teams;


}
