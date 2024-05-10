package com.crm.designers.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class AgreementDto {
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Integer number;
    private String date;
    private String partnerTypeId;
    private Set<String> productTypeIds;
    
}
