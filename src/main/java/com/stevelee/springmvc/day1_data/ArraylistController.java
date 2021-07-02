package com.stevelee.springmvc.day1_data;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArraylistController {
	
	ArrayList<Person> personlist = new ArrayList<Person>();
	
	@RequestMapping(value = "/inputperson")
	public String inputPerson() {
		
		return "day1/inputperson";
	}

	
	@RequestMapping(value = "/inputpersonform",method=RequestMethod.GET)
	public String inputPersonForm(@ModelAttribute Person person, Model model) {
		
		System.out.println("person:" + person);
		personlist.add(person);
		
		model.addAttribute("personlist", personlist);
		
		return "day1/inputpersonlist";
	}

}
