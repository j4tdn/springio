package controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Customer;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@InitBinder
	public void preHandler(WebDataBinder dataBinder) {
		// pre-process for string type >> emptyAsNull
		StringTrimmerEditor stringEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("customer", new Customer());

		return "customer/customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		
		System.out.println(customer);
		
		System.out.println("bindingResult: " + bindingResult);
		System.out.println("\n\n\n");
		
		

		return  bindingResult.hasErrors() ? "customer/customer-form" : "customer/customer";
	}
}
