package com.crm.designers.Repository;

import com.crm.designers.Entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
