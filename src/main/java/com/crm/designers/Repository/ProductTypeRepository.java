package com.crm.designers.Repository;

import com.crm.designers.Entitys.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    List<ProductType> findAllByIdIn(Set<String> productTypeIds);
    void deleteById(UUID uuid);
}
