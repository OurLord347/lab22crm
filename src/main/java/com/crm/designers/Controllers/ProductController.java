package com.crm.designers.Controllers;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Services.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private AgreementService agreementService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Agreement post(AgreementDto agreementDto) {
        return agreementService.createAgreement(agreementDto);
    }

}
