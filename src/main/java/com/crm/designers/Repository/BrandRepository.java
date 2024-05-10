package com.crm.designers.Repository;

import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findById(UUID uuid);
}
