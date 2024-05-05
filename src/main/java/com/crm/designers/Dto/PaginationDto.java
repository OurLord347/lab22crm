package com.crm.designers.Dto;

import lombok.Data;

@Data
public class PaginationDto {

    private Integer page = 0;

    private Integer limit = 10;
}
