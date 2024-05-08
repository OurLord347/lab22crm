package com.crm.designers.Repository;

import com.crm.designers.Entitys.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
