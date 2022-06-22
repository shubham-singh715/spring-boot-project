package com.techwondoe.assignment.service;

import com.techwondoe.assignment.CustomException;
import com.techwondoe.assignment.model.Company;
import com.techwondoe.assignment.model.Team;
import com.techwondoe.assignment.repository.CompanyRepository;
import com.techwondoe.assignment.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CompanyRepository companyRepository;

    public Team addTeam(Team team, UUID companyId){

        companyRepository.findById(companyId).ifPresentOrElse(
                s->{team.setCompany(s);},
                ()->{throw new CustomException("No Company with this Id found", HttpStatus.NOT_FOUND);});

        return teamRepository.save(team);

    }

    public Company getAllTeams(UUID companyId){
        return companyRepository.findById(companyId).get();
    }
}
