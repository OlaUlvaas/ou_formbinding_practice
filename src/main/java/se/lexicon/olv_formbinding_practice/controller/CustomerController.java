package se.lexicon.olv_formbinding_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.olv_formbinding_practice.repository.CustomerRepository;

@Controller
@RequestMapping("/customaising")
public class CustomerController {

    CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

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
