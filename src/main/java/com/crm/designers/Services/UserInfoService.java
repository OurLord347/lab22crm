package com.crm.designers.Services;

import com.crm.designers.Dto.UserInfoDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private AgreementService agreementService;

    public UserInfo createUserInfo(UserInfoDto userInfoDto){
        UserInfo userInfo = UserInfo.builder()
                .name(userInfoDto.getName())
                .build();
        userInfo = userInfoRepository.save(userInfo);
        agreementService.setUserInfo(userInfoDto.getAgreement(),userInfo);
        return userInfo;
    }
}
