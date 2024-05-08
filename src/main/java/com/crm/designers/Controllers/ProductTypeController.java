package com.crm.designers.Controllers;

import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Dto.ProductTypeDto;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Entitys.ProductType;
import com.crm.designers.Services.PartnerTypeService;
import com.crm.designers.Services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/productType", method = RequestMethod.POST)
    public ProductType post(ProductTypeDto productTypeDto) {
        return productTypeService.createProductType(productTypeDto);
    }

}
