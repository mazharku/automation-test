package com.mazhar.automation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mazhar.automation.model.CountryDataFormat;
import com.mazhar.automation.model.DataSourceModel;
import com.mazhar.automation.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AutomationController {

    @Autowired
    private AutomationService service;

    @GetMapping("/index")
    public String greeting(Model model) {
        model.addAttribute("datas", this.service.loadData());
        return "index";
    }


    @PostMapping(value = "/show")
    public ModelAndView show(@ModelAttribute DataSourceModel model) throws JsonProcessingException {
        System.out.println("User from UI = " + model);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("information");
        List<CountryDataFormat> countryDataFormats = service.show(model);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(countryDataFormats);
        modelAndView.addObject("data", jsonString);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView save(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        String message = service.save();
        modelAndView.setViewName("index");
        modelAndView.addObject("datas", this.service.loadData());
        modelAndView.addObject("message", message);
        return modelAndView;
    }


}
