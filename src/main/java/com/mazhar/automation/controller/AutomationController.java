package com.mazhar.automation.controller;

import com.mazhar.automation.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutomationController {

    @Autowired
    private AutomationService service;
    @GetMapping("/index")
    public String greeting(Model model) {
        model.addAttribute("datas", this.service.loadData());
        return "index";
    }
}
