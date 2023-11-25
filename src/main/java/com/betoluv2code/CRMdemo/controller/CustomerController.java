package com.betoluv2code.CRMdemo.controller;

import com.betoluv2code.CRMdemo.entity.Customer;
import com.betoluv2code.CRMdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomer(Model theModel){
        List<Customer> theCustomers = customerService.findAll();
        theModel.addAttribute("customers", theCustomers);
        return "list-customer";
    }
}
