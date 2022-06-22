package com.techwondoe.assignment.dto.resp;

import com.techwondoe.assignment.model.Team;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class CompanyRespDTO2 {
    private UUID companyId;
    private String companyName;
    private String companyCEO;
    private String companyAddress;
    private Date inceptionDate;
    private List<Team> teams;
}
