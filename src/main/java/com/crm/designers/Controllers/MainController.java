package com.crm.designers.Controllers;

import com.crm.designers.Dto.PaginationDto;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Services.*;
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
    @Autowired
    PartnerTypeService partnerTypeService;
    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("chapter", "main/main");
        return "main/index";
    }

    @RequestMapping(value = "/settings/productTypes", method = RequestMethod.GET)
    public String settingsProductTypes(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/settings");
        model.addAttribute("setting", "settings/productTypes");
        model.addAttribute("pagination", "pagination/settings/productTypes");
        model.addAttribute("paginationPages", Math.ceil(productTypeService.getCount()/10)+1);
        model.addAttribute("paginationsData", productTypeService.getProductTypes(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/settings/productTypesPagination", method = RequestMethod.GET)
    public String settingsProductTypesPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages", Math.ceil(productTypeService.getCount()/10)+1);
        model.addAttribute("paginationsData", productTypeService.getProductTypes(paginationDto));
        return "pagination/settings/productTypes";
    }

    @RequestMapping(value = "/settings/partnerTypes", method = RequestMethod.GET)
    public String settingsPartnerTypes(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/settings");
        model.addAttribute("setting", "settings/partnerTypes");
        model.addAttribute("pagination", "pagination/settings/partnerTypes");
        model.addAttribute("paginationPages", Math.ceil(partnerTypeService.getCount()/10)+1);
        model.addAttribute("paginationsData", partnerTypeService.getPartnerTypes(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/settings/partnerTypesPagination", method = RequestMethod.GET)
    public String settingsPartnerTypesPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages", Math.ceil(partnerTypeService.getCount()/10)+1);
        model.addAttribute("paginationsData", partnerTypeService.getPartnerTypes(paginationDto));
        return "pagination/settings/partnerTypes";
    }

    @RequestMapping(value = "/agreement", method = RequestMethod.GET)
    public String agreement(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/agreement");
        model.addAttribute("pagination", "pagination/agreement");
        model.addAttribute("partnerTypes", partnerTypeService.getPartnerTypes());
        model.addAttribute("productTypes", productTypeService.getProductTypes());
        model.addAttribute("paginationPages", Math.ceil(agreementService.getCount()/10)+1);
        model.addAttribute("paginationsData", agreementService.getAgreements(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/agreementPagination", method = RequestMethod.GET)
    public String agreementPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages",  Math.ceil(agreementService.getCount()/10)+1);
        model.addAttribute("paginationsData", agreementService.getAgreements(paginationDto));
        return "pagination/agreement";
    }

    @RequestMapping(value = "/designers", method = RequestMethod.GET)
    public String designers(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/designers");
        model.addAttribute("agreements", agreementService.getAgreements());
        model.addAttribute("pagination", "pagination/designers");
        model.addAttribute("paginationPages", Math.ceil(userInfoService.getCount()/10)+1);
        model.addAttribute("paginationsData", userInfoService.getUsersInfo(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/designersPagination", method = RequestMethod.GET)
    public String designersPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages", Math.ceil(userInfoService.getCount()/10)+1);
        model.addAttribute("paginationsData", userInfoService.getUsersInfo(paginationDto));
        return "pagination/designers";
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String products(PaginationDto paginationDto, Model model) {
        model.addAttribute("chapter", "main/invoices");
        model.addAttribute("pagination", "pagination/invoices");
        model.addAttribute("paginationPages", Math.ceil(userInfoService.getCount()/10)+1);
        model.addAttribute("paginationsData", invoiceService.getInvoices(paginationDto));
        return "main/index";
    }

    @RequestMapping(value = "/invoicesPagination", method = RequestMethod.GET)
    public String productsPagination(PaginationDto paginationDto, Model model) {
        model.addAttribute("paginationPages", Math.ceil(invoiceService.getCount()/10)+1);
        model.addAttribute("paginationsData", invoiceService.getInvoices(paginationDto));
        return "pagination/invoices";
    }
}
