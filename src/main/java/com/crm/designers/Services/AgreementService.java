package com.crm.designers.Services;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service
public class AgreementService {
    @Autowired
    private AgreementRepository agreementRepository;
    @Autowired
    private PartnerTypeService partnerTypeService;
    @Autowired
    private ProductTypeService productTypeService;

    public Agreement createAgreement(AgreementDto agreementDto) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Agreement agreement = Agreement.builder()
                .number(agreementDto.getNumber())
                .partnerType(partnerTypeService.getPartnerType(agreementDto.getPartnerTypeId()))
                .productTypes(productTypeService.getProductTypes(agreementDto.getProductTypeIds()))
                .dateConclusion(formatter.parse(agreementDto.getDate()))
                .build();
        return agreementRepository.save(agreement);
    }

    public List<Agreement> getAgreements() {
        return agreementRepository.findAll();
    }

    public List<Agreement> getAgreements(PaginationDto paginationDto) {
        Pageable pageable = PageRequest.of(paginationDto.getPage(), paginationDto.getLimit());
        Page<Agreement> agreements = agreementRepository.findAll(pageable);
        return agreements.getContent();
    }

    public Agreement getAgreement(String uuid) {
        return agreementRepository.findById(UUID.fromString(uuid));
    }

    public Agreement getAgreementByNumber(Integer number) {
        return agreementRepository.findAgreementByNumber(number).get();
    }

    public Agreement setUserInfo(String AgreementUuid, UserInfo userInfo) {
        Agreement agreement = getAgreement(AgreementUuid);
        agreement.setUserInfo(userInfo);
        return agreementRepository.save(agreement);
    }

    public Long getCount() {
        return agreementRepository.count();
    }
}
