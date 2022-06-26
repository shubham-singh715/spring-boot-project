package com.techwondoe.assignment;

import com.techwondoe.assignment.model.Company;
import com.techwondoe.assignment.model.Team;
import com.techwondoe.assignment.repository.CompanyRepository;
import com.techwondoe.assignment.repository.TeamRepository;
import com.techwondoe.assignment.service.TeamService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = TeamService.class)
public class TeamServiceTest {

    @Autowired
    TeamService teamService;

    @MockBean
    TeamRepository teamRepository;

    @MockBean
    CompanyRepository companyRepository;

    Team team;
    Company company;

    @BeforeAll
    public void beforeAll(){

        team=new Team();
        team.setTeamId(UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba547"));
        team.setTeamLeadName("Raj");

        company=new Company();
        company.setCompanyName("CompanyX");
        company.setCompanyId(UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba437"));
        company.setCompanyCEO("Raj");
        company.setCompanyAddress("India");

        companyRepository.save(company);
        when(companyRepository.findById(UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba437"))).thenReturn(Optional.ofNullable(company));

        when(teamRepository.save(team)).thenReturn(team);
    }

    @Test
    public void addTeam(){

        assertEquals(team.getTeamLeadName(),teamService.addTeam(team,UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba437")).getTeamLeadName());

    }

    @Test
    public void getAllTeam(){

        assertEquals(company.getCompanyName(),teamService.getAllTeams(UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba437")).getCompanyName());
    }
}
