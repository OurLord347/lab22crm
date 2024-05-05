package com.crm.designers.Controllers;

import com.crm.designers.Dto.AgreementDto;
import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Services.AgreementService;
import com.crm.designers.Services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductController {

    @Autowired
    private AgreementService agreementService;

    @Autowired
    private ExcelService excelService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Agreement post(AgreementDto agreementDto) {
        return agreementService.createAgreement(agreementDto);
    }

    @PostMapping("/upload-product-excel")
    public String uploadProductExcel(@RequestParam("file") MultipartFile file) {
        try {
            excelService.saveProducts(file);
        } catch (Exception e) {
            System.err.println("Ошибка при чтении Excel файла: " + e.getMessage());
        }
//        model.addAttribute("chapter", "main/product");
        return "main/index";
    }
}
