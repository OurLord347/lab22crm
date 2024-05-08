package com.crm.designers.Controllers;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Services.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class AgreementController {

    @Autowired
    private AgreementService agreementService;

    @RequestMapping(value = "/agreement", method = RequestMethod.POST)
    public Agreement post(AgreementDto agreementDto) throws ParseException {
        return agreementService.createAgreement(agreementDto);
    }

}
