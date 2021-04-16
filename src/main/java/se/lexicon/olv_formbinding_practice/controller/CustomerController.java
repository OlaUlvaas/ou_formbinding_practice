package se.lexicon.olv_formbinding_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.lexicon.olv_formbinding_practice.entity.Customer;
import se.lexicon.olv_formbinding_practice.entity.CustomerDetails;
import se.lexicon.olv_formbinding_practice.repository.CustomerRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/customaising")
public class CustomerController {

    CustomerRepository customerRepository;



    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customerList";
    }


    @GetMapping("/addForm")
    public String showCustomerForm(Model model){

        Customer cst = new Customer();
        model.addAttribute("cst", cst);

        return "customerForm";
    }


    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("cst") @Valid Customer cst, BindingResult bindingResult){
        System.out.println("Customer: = " + cst);

        if(bindingResult.hasErrors()){
            return "customerForm";
        }

        customerRepository.save(cst);

        return "redirect:/customaising/";
    }



}
