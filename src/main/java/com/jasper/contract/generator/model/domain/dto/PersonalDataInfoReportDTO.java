package com.jasper.contract.generator.model.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataInfoReportDTO {

    private String name;
    private String CPF;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthDate;
    private int addressNumber;
    private String streatName;
    private String cityName;
    private String stateName;
}
