package se.lexicon.olv_formbinding_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customaising")
public class CustomerController {

    @GetMapping("/")
    public String getAll(){
        return "customerList";
    }

    @GetMapping("/addForm")
    public String showCustomerForm(){
        return "customerForm";
    }

    @PostMapping("/add")
    public String addCustomer(){
        return "redirect:/customaising/";
    }



}
