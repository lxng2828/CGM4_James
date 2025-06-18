package com.example.app.Controller;

import com.example.app.model.Customer;
import com.example.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    private static final String VIEW_LIST = "list";
    private static final String VIEW_FORM = "form";
    private static final String REDIRECT_TO_LIST = "redirect:/";
    private static final String ATTRIBUTE_CUSTOMERS = "customers";
    private static final String ATTRIBUTE_CUSTOMER = "customer";


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        List<Customer> customerList = this.customerService.findAll();

        model.addAttribute(ATTRIBUTE_CUSTOMERS, customerList);

        return VIEW_LIST;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        Customer newCustomer = new Customer();
        model.addAttribute(ATTRIBUTE_CUSTOMER, newCustomer);
        return VIEW_FORM;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(
            @RequestParam("name") String customerName,
            @RequestParam("email") String customerEmail,
            @RequestParam("address") String customerAddress
    ) {
        Customer customerToSave = new Customer(null, customerName, customerEmail, customerAddress);

        this.customerService.Save(customerToSave);

        return REDIRECT_TO_LIST;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Long customerId, Model model) {
        Customer customerToEdit = this.customerService.findById(customerId);
        model.addAttribute(ATTRIBUTE_CUSTOMER, customerToEdit);
        return VIEW_FORM;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable("id") Long customerIdToDelete) {
        this.customerService.Remove(customerIdToDelete);
        return REDIRECT_TO_LIST;
    }
}