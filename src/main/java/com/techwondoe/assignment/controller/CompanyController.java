package com.techwondoe.assignment.controller;

import com.techwondoe.assignment.dto.req.CompanyReqDTO;
import com.techwondoe.assignment.dto.resp.CompanyRespDTO;
import com.techwondoe.assignment.model.Company;
import com.techwondoe.assignment.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/")
    @ApiOperation(value = "Creating a Company")
    public CompanyRespDTO addCompany(@RequestBody CompanyReqDTO companyReqDTO){
        Company company= modelMapper.map(companyReqDTO,Company.class);
        return modelMapper.map(companyService.addCompany(company),CompanyRespDTO.class);
    }

    @GetMapping("/")
    @ApiOperation(value = "Getting Company By Id")
    public CompanyRespDTO getCompanyById(@RequestParam ("companyId")UUID companyId){

        return modelMapper.map(companyService.getCompanyById(companyId),CompanyRespDTO.class);
    }

    @GetMapping("/{companyName}")
    @ApiOperation(value = "Search Company By Name")
    public List<CompanyRespDTO> getCompanyByName(@PathVariable ("companyName") String companyName){
        return companyService.getComapnyByName(companyName)
                .stream()
                .map(company -> modelMapper.map(company,CompanyRespDTO.class))
                .collect(Collectors.toList());

    }

}
