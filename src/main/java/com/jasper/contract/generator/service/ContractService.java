package com.jasper.contract.generator.service;

import com.jasper.contract.generator.model.domain.dto.PersonalDataInfoReportDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface ContractService {

    byte[] generateContract(PersonalDataInfoReportDTO personalDataInfoReportDTO) throws IOException, JRException;
}