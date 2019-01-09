package com.lti.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.mvc.exception.CustomException;
import com.lti.mvc.model.Person;
import com.lti.mvc.service.IPersonService;

@Controller
@Component
public class PersonController {
	
	private IPersonService personService;
	
	@Autowired
	@Qualifier(value="personService")
	public void setPersonService(IPersonService ps) {
		this.personService = ps;
	}
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView handlePersonNotFoundException(CustomException ex) {
		Map<String, CustomException> model = new HashMap<String, CustomException>();
		model.put("exception", ex);
		return new ModelAndView("error", model);

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		Map<String, Exception> model = new HashMap<String, Exception>();
		model.put("exception", ex);
		return new ModelAndView("error", model);

	}
	
	@RequestMapping(value="/persons")
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons",this.personService.listPersons());
		return "person";
	}
	
	// For add and update person both
		@RequestMapping(value = "/person/add", 
				method = RequestMethod.POST)
		@ExceptionHandler({ CustomException.class })
		public String addPerson(
				@ModelAttribute("person") 
				@Valid Person p, 
				BindingResult result, 
				Model model) {
			if (!result.hasErrors()) {
				if (p.getId() == null) {
					// new person, add it
					this.personService.addPerson(p);
				} else {
					// existing person, call update
					this.personService.updatePerson(p);
				}
				return "redirect:/persons";
			}
			model.addAttribute("listPersons", this.personService.listPersons());
			return "person";

		}
		
		@RequestMapping("/edit/{id}")
		public String showEditPersonPage(
				@PathVariable("id") int id, Model model) {
			Person personObj = 
					this.personService.getPersonById(id);
			model.addAttribute("person", personObj);
			List<Person> personListObj =
					this.personService.listPersons();
			model.addAttribute("listPersons", personListObj);
			return "person";// view name
		}

		@RequestMapping("/remove/{id}")
		@ExceptionHandler({ CustomException.class })
		public String removePerson(@PathVariable("id") int id) throws CustomException {
			if (id > 0) {
				this.personService.removePerson(id);
					
				
			} else {
				throw new CustomException("Given Id Not Found","404");		
			}
			return "redirect:/persons";
		}
		
		@RequestMapping("/showErrorPage/error")
		@ExceptionHandler(Exception.class)
		public ModelAndView exception(Exception e) {

			ModelAndView mav = new ModelAndView("error");// view name
			mav.addObject("exName", e.getClass().getSimpleName());// model for ex name
			mav.addObject("exMessage", e.getMessage());// model for ex msg
			return mav;
		}

}
