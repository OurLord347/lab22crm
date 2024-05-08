package com.crm.designers.Services;

import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Dto.PartnerTypeDto;
import com.crm.designers.Entitys.PartnerType;
import com.crm.designers.Repository.PartnerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartnerTypeService {
    @Autowired
    private PartnerTypeRepository partnerTypeRepository;

    public PartnerType createPartnerType(PartnerTypeDto agreementDto) {
        PartnerType partnerType = PartnerType.builder()
                .name(agreementDto.getName())
                .build();
        return partnerTypeRepository.save(partnerType);
    }

    public PartnerType getPartnerType(String uuid) {
        return partnerTypeRepository.findById(UUID.fromString(uuid));
    }

    public List<PartnerType> getPartnerTypes() {
        return partnerTypeRepository.findAll();
    }

    public List<PartnerType> getPartnerTypes(PaginationDto paginationDto) {
        Pageable pageable = PageRequest.of(paginationDto.getPage(), paginationDto.getLimit());
        Page<PartnerType> agreements = partnerTypeRepository.findAll(pageable);
        return agreements.getContent();
    }

    public Long getCount() {
        return partnerTypeRepository.count();
    }
}
