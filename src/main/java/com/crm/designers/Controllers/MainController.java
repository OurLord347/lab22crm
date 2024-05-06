package com.crm.designers.Controllers;

import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Services.AgreementService;
import com.crm.designers.Services.InvoiceService;
import com.crm.designers.Services.ProductService;
import com.crm.designers.Services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @Autowired
    AgreementService agreementService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("chapter", "main/main");
        return "main/index";
    }

    @RequestMapping(value = "/agreement", method = RequestMethod.GET)
    public String agreement(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/agreement");
        model.addAttribute("pagination", "pagination/agreement");
        model.addAttribute("paginationPages", Math.ceil(agreementService.getCountAgreement()/10)+1);
        model.addAttribute("paginationsData", agreementService.getAgreements(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/agreementPagination", method = RequestMethod.GET)
    public String agreementPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages",  Math.ceil(agreementService.getCountAgreement()/10)+1);
        model.addAttribute("paginationsData", agreementService.getAgreements(paginationDto));
        return "pagination/agreement";
    }

    @RequestMapping(value = "/designers", method = RequestMethod.GET)
    public String designers(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/designers");
        model.addAttribute("agreements", agreementService.getAgreements());
        model.addAttribute("pagination", "pagination/designers");
        model.addAttribute("paginationPages", Math.ceil(userInfoService.getUserInfoCount()/10)+1);
        model.addAttribute("paginationsData", userInfoService.getUsersInfo(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/designersPagination", method = RequestMethod.GET)
    public String designersPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages", Math.ceil(userInfoService.getUserInfoCount()/10)+1);
        model.addAttribute("paginationsData", userInfoService.getUsersInfo(paginationDto));
        return "pagination/designers";
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String products(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/invoices");
        model.addAttribute("pagination", "pagination/invoices");
        model.addAttribute("paginationPages", Math.ceil(userInfoService.getUserInfoCount()/10)+1);
        model.addAttribute("paginationsData", invoiceService.getInvoices(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/invoicesPagination", method = RequestMethod.GET)
    public String productsPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages", Math.ceil(invoiceService.getInvoicesCount()/10)+1);
        model.addAttribute("paginationsData", invoiceService.getInvoices(paginationDto));
        return "pagination/invoices";
    }
}
