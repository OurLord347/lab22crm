package com.crm.designers.Controllers;

import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Dto.ProductTypeDto;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Entitys.ProductType;
import com.crm.designers.Services.PartnerTypeService;
import com.crm.designers.Services.ProductTypeService;
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
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @Operation(summary = "Получение типов товаров")
    @RequestMapping(value = "/productType/{id}", method = RequestMethod.GET)
    public ProductType get(@PathVariable UUID id) {
        return productTypeService.getPartnerType(id);
    }

    @Operation(summary = "Редактирование типа товаров")
    @RequestMapping(value = "/productType", method = RequestMethod.PUT)
    public ProductType put(ProductTypeDto productTypeDto) {
        return productTypeService.updatePartnerType(productTypeDto);
    }

    @Operation(summary = "Создание типа товаров")
    @RequestMapping(value = "/productType", method = RequestMethod.POST)
    public ProductType post(ProductTypeDto productTypeDto) {
        return productTypeService.createProductType(productTypeDto);
    }

    @Operation(summary = "Удаление типа товаров")
    @Transactional
    @RequestMapping(value="/productType/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
     }

}
