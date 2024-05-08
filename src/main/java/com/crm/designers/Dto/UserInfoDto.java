package com.crm.designers.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserInfoDto {
    private String surname; //Фамилия
    private String name; // Имя
    private String lastname; // Отчество
    private String phone; // телефон
    private List<String> contactLinks = new ArrayList<>();
    private String agreementId; //id договора
}
