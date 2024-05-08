package com.crm.designers.Controllers;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Services.AgreementService;
import com.crm.designers.Services.PartnerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerTypeController {

    @Autowired
    private PartnerTypeService partnerTypeService;

    @RequestMapping(value = "/partnerType", method = RequestMethod.POST)
    public PartnerType post(PartnerTypeDto partnerTypeDto) {
        return partnerTypeService.createPartnerType(partnerTypeDto);
    }

}
