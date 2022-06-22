package com.techwondoe.assignment.dto.resp;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CompanyRespDTO {

    private UUID companyId;
    private String companyName;
    private String companyCEO;
    private String companyAddress;
    private Date inceptionDate;

}
