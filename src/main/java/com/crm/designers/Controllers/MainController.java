package com.crm.designers.Controllers;

import com.crm.designers.Services.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    AgreementService agreementService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("chapter", "main/main");
        return "main/index";
    }

    @RequestMapping(value = "/agreement", method = RequestMethod.GET)
    public String agreement(Model model) {
        model.addAttribute("chapter", "main/agreement");
        return "main/index";
    }

    @RequestMapping(value = "/designers", method = RequestMethod.GET)
    public String designers(Model model) {
        model.addAttribute("chapter", "main/designers");
        model.addAttribute("agreements", agreementService.getAgreements());
        return "main/index";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String products(Model model) {
        model.addAttribute("chapter", "main/product");
        return "main/index";
    }
}
