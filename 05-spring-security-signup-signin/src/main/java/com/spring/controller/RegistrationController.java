package com.spring.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.User;
import com.spring.model.UserModel;
import com.spring.service.UserService;

@Controller
public class RegistrationController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/signup")
	public String showForm(Model model) {
		model.addAttribute("user", new UserModel());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String processForm(@Valid @ModelAttribute("user") UserModel userModel,
			BindingResult bindingResult, Model model) {
		
		String username = userModel.getUserName();
		logger.info("\n*** Processing register user " + username + "\n");
		
		if (bindingResult.hasErrors()) {
			return "signup";
		}
		
		// check user exists in database
		User existing = userService.findByUserName(username);
		if (existing != null) {
			logger.warning("\n*** Username already exists \n");
			
			model.addAttribute("user", userModel);
			model.addAttribute("registrationError", "Username already exists !");
			return "signup";
		}
		
		userService.save(userModel);
		
		logger.info("\n*** Register success \n");
		return "signup-success";
	}
}
