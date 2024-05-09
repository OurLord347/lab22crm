package com.crm.designers.Services;

import com.crm.designers.Dto.BrandDto;
import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Entitys.Brand;
import com.crm.designers.Entitys.Invoice;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.BrandRepository;
import com.crm.designers.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand createBrand(BrandDto brandDto, UserInfo userInfo) {
        Brand partnerType = Brand.builder()
                .name(brandDto.getBrandName())
                .description(brandDto.getBrandDescription())
                .userInfo(userInfo)
                .build();
        return brandRepository.save(partnerType);
    }
}
