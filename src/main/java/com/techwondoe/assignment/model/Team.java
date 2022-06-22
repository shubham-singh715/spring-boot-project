package com.techwondoe.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID teamId;

    private String teamLeadName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
}
