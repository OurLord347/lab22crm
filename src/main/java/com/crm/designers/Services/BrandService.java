package com.crm.designers.Services;

import com.crm.designers.Dto.BrandDto;
import com.crm.designers.Entitys.Brand;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand updateBrand(BrandDto brandDto) {
        Brand partnerType = brandRepository.findById(UUID.fromString(brandDto.getId()));
        partnerType.setDescription(brandDto.getBrandDescription());
        partnerType.setName(brandDto.getBrandName());
        return brandRepository.save(partnerType);
    }

    public Brand createBrand(BrandDto brandDto, UserInfo userInfo) {
        Brand brand = Brand.builder()
                .name(brandDto.getBrandName())
                .description(brandDto.getBrandDescription())
                .userInfo(userInfo)
                .build();
        return brandRepository.save(brand);
    }
}
