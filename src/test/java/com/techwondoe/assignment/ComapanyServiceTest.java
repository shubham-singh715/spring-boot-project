package com.techwondoe.assignment;

import com.techwondoe.assignment.model.Company;
import com.techwondoe.assignment.repository.CompanyRepository;
import com.techwondoe.assignment.service.CompanyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = CompanyService.class)
public class ComapanyServiceTest {

    @Autowired
    CompanyService companyService;

    @MockBean
    CompanyRepository companyRepository;


    Company company;

    @BeforeAll
    public void beforeAll(){
    company=new Company();
        company.setCompanyName("CompanyX");
        company.setCompanyId(UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba437"));
        company.setCompanyCEO("Raj");
        company.setCompanyAddress("India");
    }

    @Test
    public void addCompanyTest(){

        when(companyRepository.save(company)).thenReturn(company);

        assertEquals(company.getCompanyCEO(),companyService.addCompany(company).getCompanyCEO());

    }

    @Test
    public void getCompanyByIdTest(){

        when(companyRepository.findById(UUID.fromString("00845cd2-5a78-441f-9c54-c7cfdfcba437")))
                .thenReturn(Optional.ofNullable(company));

        assertEquals(Optional.ofNullable(company).get().getCompanyId(),company.getCompanyId());

    }

    @Test
    public void getCompanyByName(){

        when(companyRepository.findByCompanyName("CompanyX"))
                .thenReturn(Collections.singletonList(company));

        assertEquals(company.getCompanyName(),companyService.getComapnyByName("CompanyX").get(0).getCompanyName());
    }


}
