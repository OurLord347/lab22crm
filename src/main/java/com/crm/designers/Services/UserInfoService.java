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
    public Long getUserInfoCount(){
        return userInfoRepository.count();
    }

    public List<UserInfo> getUsersInfo(PaginationDto paginationDto){
        Pageable pageable = PageRequest.of(paginationDto.getPage(),paginationDto.getLimit());
        Page<UserInfo> usersInfo = userInfoRepository.findAll(pageable);
        return usersInfo.getContent();
    }
}
