package com.crm.designers.Repository;

import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    void deleteById(UUID uuid);
    UserInfo findById(UUID uuid);
}
