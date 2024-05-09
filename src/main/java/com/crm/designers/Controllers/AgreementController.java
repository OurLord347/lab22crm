package com.crm.designers.Controllers;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Services.AgreementService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.UUID;

@RestController
public class AgreementController {

    @Autowired
    private AgreementService agreementService;

    @RequestMapping(value = "/agreement", method = RequestMethod.POST)
    public Agreement post(AgreementDto agreementDto) throws ParseException {
        return agreementService.createAgreement(agreementDto);
    }

    @Transactional
    @RequestMapping(value="/agreement/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        agreementService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
