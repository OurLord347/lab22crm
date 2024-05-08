package com.crm.designers.Services;

import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Entitys.Invoice;
import com.crm.designers.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoices(PaginationDto paginationDto) {
        Pageable pageable = PageRequest.of(paginationDto.getPage(), paginationDto.getLimit());
        Page<Invoice> usersInfo = invoiceRepository.findAll(pageable);
        return usersInfo.getContent();
    }

    public Long getCount() {
        return invoiceRepository.count();
    }
}
