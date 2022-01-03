package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		// model attribute
		model.addAttribute("student", new Student());
		
		model.addAttribute("countries", new String[] {"Brazil", "France", "Germany", "Poturgal"});
		model.addAttribute("languages", new String[] {"Java", "Spring MVC", "Spring Boot"});
		model.addAttribute("operatingSystems", new String[] {"Windows", "Linux", "Mac OS"});
		
		return "student/student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("Binding: " + theStudent.getFirstName() + ", " + theStudent.getLastName() + ", " + theStudent.getCountry());
		
		return "student/student";
	}
}
