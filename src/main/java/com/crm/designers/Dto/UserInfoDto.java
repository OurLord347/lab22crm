package com.crm.designers.Dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserInfoDto {
    private String id; //id записи
    private String surname; //Фамилия
    private String name; // Имя
    private String lastname; // Отчество
    private String phone; // телефон
    private List<String> contactLinks ;
    private String agreementId; //id договора

    private BrandDto brandDto;
}
