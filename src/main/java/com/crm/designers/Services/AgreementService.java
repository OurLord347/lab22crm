package com.crm.designers.Services;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.AgreementRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgreementService {
    @Autowired
    private AgreementRepository agreementRepository;
    public Agreement createAgreement(AgreementDto agreementDto){
        Agreement agreement = Agreement.builder()
                .number(Integer.valueOf(agreementDto.getNumber()))
                .build();
        return agreementRepository.save(agreement);
    }

    public List<Agreement> getAgreements(){
        return agreementRepository.findAll();
    }
    public List<Agreement> getAgreements(PaginationDto paginationDto){
        Pageable pageable = PageRequest.of(paginationDto.getPage(),paginationDto.getLimit());
        Page<Agreement> agreements = agreementRepository.findAll(pageable);
        return agreements.getContent();
    }
    public Agreement getAgreement(String uuid){
        return agreementRepository.findById(UUID.fromString(uuid));
    }

    public Agreement getAgreementByNumber(Integer number){
        return agreementRepository.findAgreementByNumber(number).get();
    }

    public Agreement setUserInfo(String AgreementUuid, UserInfo userInfo){
        Agreement agreement = getAgreement(AgreementUuid);
        agreement.setUserInfo(userInfo);
        return agreementRepository.save(agreement);
    }

    public Long getCount(){
        return agreementRepository.count();
    }
}
