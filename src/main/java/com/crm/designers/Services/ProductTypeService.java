package com.crm.designers.Services;

import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Dto.ProductTypeDto;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Entitys.ProductType;
import com.crm.designers.Repository.PartnerTypeRepository;
import com.crm.designers.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductType createProductType(ProductTypeDto productTypeDto){
        ProductType partnerType = ProductType.builder()
                .name(productTypeDto.getName())
                .build();
        return save(partnerType);
    }

    public ProductType save(ProductType productType){
        return productTypeRepository.save(productType);
    }

    public List<ProductType> getProductTypes(PaginationDto paginationDto){
        Pageable pageable = PageRequest.of(paginationDto.getPage(),paginationDto.getLimit());
        Page<ProductType> agreements = productTypeRepository.findAll(pageable);
        return agreements.getContent();
    }

    public Long getCount(){
        return productTypeRepository.count();
    }
}
