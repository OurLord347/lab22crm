package com.crm.designers.Controllers;

import com.crm.designers.Services.AgreementService;
import com.crm.designers.Services.ExcelService;
import com.crm.designers.Services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class InvoiceController {
    @Autowired
    private ExcelService excelService;
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/upload-invoice-excel")
    public ResponseEntity<Map<String, String>> uploadProductExcel(@RequestParam("file") MultipartFile file) {
        excelService.saveProducts(file);
        Map<String, String> response = new HashMap<>();
        response.put("fileName", file.getOriginalFilename());
        return ResponseEntity.ok().body(response);
    }

    @Transactional
    @RequestMapping(value="/invoice/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        invoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
