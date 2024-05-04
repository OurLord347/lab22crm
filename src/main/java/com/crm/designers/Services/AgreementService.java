package com.crm.designers.Services;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AgreementService {
    @Autowired
    private AgreementRepository agreementRepository;
    public Agreement createAgreement(AgreementDto agreementDto){
        Agreement agreement = Agreement.builder()
                .number(agreementDto.getNumber())
                .build();
        return agreementRepository.save(agreement);
    }

    public List<Agreement> getAgreements(){
        return agreementRepository.findAll();
    }

    public Agreement getAgreement(String uuid){
        return agreementRepository.findById(UUID.fromString(uuid));
    }

    public Agreement setUserInfo(String AgreementUuid, UserInfo userInfo){
        Agreement agreement = getAgreement(AgreementUuid);
        agreement.setUserInfo(userInfo);
        return agreementRepository.save(agreement);
    }
}
