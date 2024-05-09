package com.crm.designers.Repository;

import com.crm.designers.Entitys.Invoice;
import com.crm.designers.Entitys.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    void deleteById(UUID uuid);
    Invoice findById(UUID uuid);
}
