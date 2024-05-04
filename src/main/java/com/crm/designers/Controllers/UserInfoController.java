package com.crm.designers.Controllers;

import com.crm.designers.Dto.UserInfoDto;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public UserInfo post(UserInfoDto userInfoDto) {
        return userInfoService.createUserInfo(userInfoDto);
    }

}
