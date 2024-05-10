package com.crm.designers.Controllers;

import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Dto.ProductTypeDto;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Entitys.ProductType;
import com.crm.designers.Services.PartnerTypeService;
import com.crm.designers.Services.ProductTypeService;
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

    @RequestMapping(value = "/productType/{id}", method = RequestMethod.GET)
    public ProductType get(@PathVariable UUID id) {
        return productTypeService.getPartnerType(id);
    }

    @RequestMapping(value = "/productType", method = RequestMethod.PUT)
    public ProductType put(ProductTypeDto productTypeDto) {
        return productTypeService.updatePartnerType(productTypeDto);
    }

    @RequestMapping(value = "/productType", method = RequestMethod.POST)
    public ProductType post(ProductTypeDto productTypeDto) {
        return productTypeService.createProductType(productTypeDto);
    }

    @Transactional
    @RequestMapping(value="/productType/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
     }

}
