package com.crm.designers.Repository;

import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    Optional<Agreement> findAgreementByNumber(Integer number);
    Agreement findById(UUID uuid);

    void deleteById(UUID uuid);
}
