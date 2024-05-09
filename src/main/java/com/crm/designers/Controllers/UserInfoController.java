package com.crm.designers.Controllers;

import com.crm.designers.Dto.UserInfoDto;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public UserInfo post(UserInfoDto userInfoDto) {
        return userInfoService.createUserInfo(userInfoDto);
    }

    @Transactional
    @RequestMapping(value = "/userInfo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userInfoService.deleteUserInfo(id);
        return ResponseEntity.noContent().build();
    }

}
