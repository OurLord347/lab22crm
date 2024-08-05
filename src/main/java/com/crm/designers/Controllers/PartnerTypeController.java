package com.crm.designers.Controllers;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Services.AgreementService;
import com.crm.designers.Services.PartnerTypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PartnerTypeController {

    @Autowired
    private PartnerTypeService partnerTypeService;

    @Operation(summary = "Получение типов сотрудничества")
    @RequestMapping(value = "/partnerType/{id}", method = RequestMethod.GET)
    public PartnerType get(@PathVariable UUID id) {
        return partnerTypeService.getPartnerType(id);
    }

    @Operation(summary = "Редактирование типа сотрудничества")
    @RequestMapping(value = "/partnerType", method = RequestMethod.PUT)
    public PartnerType put(PartnerTypeDto partnerTypeDto) {
        return partnerTypeService.updatePartnerType(partnerTypeDto);
    }

    @Operation(summary = "Создание типа сотрудничества")
    @RequestMapping(value = "/partnerType", method = RequestMethod.POST)
    public PartnerType post(PartnerTypeDto partnerTypeDto) {
        return partnerTypeService.createPartnerType(partnerTypeDto);
    }

    @Operation(summary = "Удаление типа сотрудничества")
    @Transactional
    @RequestMapping(value="/partnerType/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        partnerTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
