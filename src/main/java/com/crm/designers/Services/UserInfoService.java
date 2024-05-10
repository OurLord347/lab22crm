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

    public UserInfo updateUserInfo(UserInfoDto userInfoDto) {

        UserInfo userInfo = getUsersInfo(UUID.fromString(userInfoDto.getId()));
        userInfo.setName(userInfoDto.getName());
        userInfo.setSurname(userInfoDto.getSurname());
        userInfo.setLastname(userInfoDto.getLastname());
        userInfo.setPhone(userInfoDto.getPhone());
        userInfo = userInfoRepository.save(userInfo);
        agreementService.setUserInfo(userInfoDto.getAgreementId(), userInfo);

        //Todo сохранение ссылок
//        contactLinksService.createContactLink(userInfoDto.getContactLinks(), userInfo);

        userInfoDto.getBrandDto().setId(userInfo.getBrands().get(0).getId().toString());
        brandService.updateBrand(userInfoDto.getBrandDto());
        return userInfo;
    }

    public Long getCount() {
        return userInfoRepository.count();
    }

    public UserInfo getUsersInfo(UUID uuid) {
        return userInfoRepository.findById(uuid);
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
