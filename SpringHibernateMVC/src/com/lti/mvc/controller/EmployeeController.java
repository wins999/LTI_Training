package com.lti.mvc.controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.mvc.exception.CustomException;
import com.lti.mvc.model.EmployeeDetails;
import com.lti.mvc.model.Person;
import com.lti.mvc.service.IEmployeeDetailsSevice;

@Controller
public class EmployeeController {
	
	private IEmployeeDetailsSevice employeeDetailsService;	
	
    @Autowired
	public void setEmployeeDetailsService(IEmployeeDetailsSevice employeeDetailsService) {
		this.employeeDetailsService = employeeDetailsService;
	}



	@RequestMapping(value="/employees")
	public String listEmployee(Model model) {
		model.addAttribute("employee", new EmployeeDetails());
		model.addAttribute("listEmployee",this.employeeDetailsService.getAllEmployeeDetails());
		return "employee";
	}
	
	// For add and update person both
			@RequestMapping(value = "/employees/add", 
					method = RequestMethod.POST)
			@ExceptionHandler({ CustomException.class })
			public String addPerson(
					@ModelAttribute("employee") 
					 @Valid EmployeeDetails p, 
					BindingResult result, 
					Model model) {
				if (!result.hasErrors()) {
					if (p.getId() == null) {
						// new person, add it
						//p.setHiredate((Date)p.getHiredate());
						this.employeeDetailsService.createEmployeeDetails(p);
					} else {
						// existing person, call update
						this.employeeDetailsService.updateEmployeeDetails(p);
					}
					return "redirect:/employees";
				}
				model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
				return "employee";

			}

	
	
	

}
