package com.crm.designers.Repository;

import com.crm.designers.Entitys.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
