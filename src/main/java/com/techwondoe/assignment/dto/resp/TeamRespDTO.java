package com.techwondoe.assignment.dto.resp;

import lombok.Data;

import java.util.UUID;

@Data
public class TeamRespDTO {

    private UUID teamId;
    private String teamLeadName;
}
