package com.techwondoe.assignment.controller;

import com.techwondoe.assignment.dto.req.TeamReqDTO;
import com.techwondoe.assignment.dto.resp.CompanyRespDTO2;
import com.techwondoe.assignment.dto.resp.TeamRespDTO;
import com.techwondoe.assignment.model.Team;
import com.techwondoe.assignment.service.TeamService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/{companyId}")
    @ApiOperation(value = "Creating a Team ")
    public TeamRespDTO addTeam(@RequestBody TeamReqDTO teamReqDTO, @PathVariable ("companyId")UUID companyId){
        Team team = modelMapper.map(teamReqDTO,Team.class);
        return modelMapper.map(teamService.addTeam(team,companyId),TeamRespDTO.class);
    }

    @GetMapping("/")
    @ApiOperation(value = "Getting All Teams")
    public CompanyRespDTO2 getAllTeams(@RequestParam ("companyId") UUID companyId){
        return modelMapper.map(teamService.getAllTeams(companyId), CompanyRespDTO2.class);
    }

}
