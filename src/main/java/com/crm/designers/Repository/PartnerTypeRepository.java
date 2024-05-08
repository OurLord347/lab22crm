package com.crm.designers.Repository;

import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.PartnerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartnerTypeRepository extends JpaRepository<PartnerType, Long> {
    PartnerType findById(UUID uuid);
}
