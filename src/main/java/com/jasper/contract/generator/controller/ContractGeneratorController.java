package com.jasper.contract.generator.controller;

import com.jasper.contract.generator.model.domain.dto.PersonalDataInfoReportDTO;
import com.jasper.contract.generator.service.ContractService;
import io.swagger.annotations.Api;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//@RequestMapping(path = "/contract")
@RestController(value = "/contract")
@Api("Contract and Report Controller Manager")
public class ContractGeneratorController {

    @Autowired
    ContractService contractService;

    @PostMapping(value = "/generate",produces = MediaType.APPLICATION_PDF_VALUE)
    public void generateContract(@RequestBody(required = true) PersonalDataInfoReportDTO personalDataInfoReportDTO)
            throws IOException, JRException {

        byte[] contract = contractService.generateContract(personalDataInfoReportDTO);

        ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + 1 + ".pdf")
                .contentLength(contract.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(contract);
    }
}
