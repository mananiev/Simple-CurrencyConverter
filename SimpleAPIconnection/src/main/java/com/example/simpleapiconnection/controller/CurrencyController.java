package com.example.simpleapiconnection.controller;

import com.example.simpleapiconnection.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/convert")
    public String result(@RequestParam String from, @RequestParam String to, @RequestParam double amount, Model model) {

        double result = amount * currencyService.Convert(from,to);
        model.addAttribute("result", result);
        return "result";
    }
}
