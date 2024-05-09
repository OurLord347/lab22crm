package com.crm.designers.Services;

import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Dto.UserInfoDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private AgreementService agreementService;
    @Autowired
    private ContactLinksService contactLinksService;
    @Autowired
    private BrandService brandService;

    public UserInfo createUserInfo(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfo.builder()
                .surname(userInfoDto.getSurname())
                .name(userInfoDto.getName())
                .lastname(userInfoDto.getLastname())
                .phone(userInfoDto.getPhone())
                .build();
        userInfo = userInfoRepository.save(userInfo);
        agreementService.setUserInfo(userInfoDto.getAgreementId(), userInfo);
        contactLinksService.createContactLink(userInfoDto.getContactLinks(), userInfo);
        brandService.createBrand(userInfoDto.getBrandDto(), userInfo);
        return userInfo;
    }

    public Long getCount() {
        return userInfoRepository.count();
    }

    public List<UserInfo> getUsersInfo(PaginationDto paginationDto) {
        Pageable pageable = PageRequest.of(paginationDto.getPage(), paginationDto.getLimit());
        Page<UserInfo> usersInfo = userInfoRepository.findAll(pageable);
        return usersInfo.getContent();
    }

    public void deleteUserInfo(UUID userInfoId) {
        UserInfo userInfo = userInfoRepository.findById(userInfoId);
        for (Agreement agreement : userInfo.getAgreements()) {
            agreement.setUserInfo(null);
            agreementService.save(agreement);
        }
        userInfoRepository.deleteById(userInfoId);
    }
}
