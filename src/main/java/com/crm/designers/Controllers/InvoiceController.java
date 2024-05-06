package com.crm.designers.Controllers;

import com.crm.designers.Services.AgreementService;
import com.crm.designers.Services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InvoiceController {
    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload-invoice-excel")
    public ResponseEntity<Map<String, String>> uploadProductExcel(@RequestParam("file") MultipartFile file) {
        excelService.saveProducts(file);
        Map<String, String> response = new HashMap<>();
        response.put("fileName", file.getOriginalFilename());
        return ResponseEntity.ok().body(response);
    }
}
