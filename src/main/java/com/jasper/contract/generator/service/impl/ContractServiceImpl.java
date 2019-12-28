package com.jasper.contract.generator.service.impl;

import com.jasper.contract.generator.model.domain.dto.PersonalDataInfoReportDTO;
import com.jasper.contract.generator.service.ContractService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ContractServiceImpl implements ContractService {

    @Value("${contract.file.path}")
    private String CONTRACT_FILE_PATH;


    @Override
    public byte[] generateContract(PersonalDataInfoReportDTO personalDataInfoReportDTO) throws IOException, JRException {
        Resource resource = new ClassPathResource(CONTRACT_FILE_PATH);
        JasperReport contract = JasperCompileManager.compileReport(resource.getInputStream());
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                contract,
                null,
                new JRBeanCollectionDataSource(Arrays.asList(personalDataInfoReportDTO), false));

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
