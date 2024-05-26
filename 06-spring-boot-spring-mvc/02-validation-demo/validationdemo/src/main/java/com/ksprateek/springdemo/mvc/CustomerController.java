package com.ksprateek.springdemo.mvc;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    //Request mapping for form
    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    //Request mapping to process the form
    @PostMapping("/processForm")
    //@ModelAttribute reads the customer information posted by the html form
    //@Valid performs form validation according to the rules specified in Customer class
    //BindingResult object theBindingResult is the result of validation
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer
    , BindingResult theBindingResult){
        //Print statement for debugging
        System.out.println("Last Name: |" + theCustomer.getLastName() + "|");
        //if validation fails, return the user back to customer-form page. If it succeeds, redirect user to customer-confirmation page
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }
    }

    //Use @InitBinder to pre-process requests
    //For every new request that comes to our controller, @InitBinder code will execute first
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //this initBinder method pre-processes every String form data, removes leading and trailing white space. If String has only white space, trim it to null.
//        StringTrimmerEditor is defined in Spring API to remove leading and trailing whitespaces
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        For every string class apply stringTrimmerEditor:
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
