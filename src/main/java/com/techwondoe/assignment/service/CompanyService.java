package com.techwondoe.assignment.service;

import com.techwondoe.assignment.model.Company;
import com.techwondoe.assignment.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }


    public Company getCompanyById(UUID companyId){

    return companyRepository.findById(companyId).get();
    }

    public List<Company> getComapnyByName(String companyName){
        return companyRepository.findByCompanyName(companyName);
    }

}


