package com.crm.designers.Repository;

import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
//    Optional<UserInfo> findAgreementByName(String name);
}
