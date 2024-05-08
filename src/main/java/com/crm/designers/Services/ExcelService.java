package com.crm.designers.Services;

import com.crm.designers.Entitys.Agreement;
import com.crm.designers.Entitys.Invoice;
import com.crm.designers.Entitys.Product;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@Service
public class ExcelService {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AgreementService agreementService;

    @Autowired
    private FileService fileService;

    public void saveProducts(MultipartFile file) {
        Workbook workbook = null;

        try {
            workbook = WorkbookFactory.create(new ByteArrayInputStream(file.getBytes()));

            for (Sheet sheet : workbook) {

                double agreementNumber = sheet.getRow(13).getCell(4).getNumericCellValue();
                Agreement agreement = agreementService.getAgreementByNumber((int) agreementNumber);

                Invoice invoice = Invoice.builder()
                        .fileName(file.getOriginalFilename())
                        .agreement(agreement)
                        .build();
                invoice = invoiceService.save(invoice);

                fileService.saveLocalFile(file, invoice.getId().toString());

                int rowListNum = 22;
                while (!sheet.getRow(rowListNum).getCell(1).getStringCellValue().isEmpty()) {
                    Row row = sheet.getRow(rowListNum);
                    String productName = row.getCell(1).getStringCellValue();
                    Product product = Product.builder()
                            .invoice(invoice)
                            .name(productName)
                            .build();
                    productService.save(product);
                    rowListNum++;
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при чтении Excel файла: " + e.getMessage());
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии книги Excel: " + e.getMessage());
                }
            }
        }
    }


}
