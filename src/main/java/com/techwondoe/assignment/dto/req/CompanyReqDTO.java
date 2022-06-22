package com.techwondoe.assignment.dto.req;

import lombok.Data;

import java.util.Date;

@Data
public class CompanyReqDTO {

    private String companyName;
    private String companyCEO;
    private String companyAddress;
    private Date inceptionDate;
}
