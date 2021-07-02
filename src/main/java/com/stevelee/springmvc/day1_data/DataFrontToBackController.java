package com.stevelee.springmvc.day1_data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataFrontToBackController {
	

	@RequestMapping(value = "inputpersonget")
	public String inputPersonPost() {
		
		return "day1/inputpersonget";
	}
	
	@ResponseBody
	@RequestMapping(value = "inputpersongetajax",method = RequestMethod.GET)
	public String inputPersonGetAjax(@ModelAttribute Person person) {
		
		System.out.println("person:" + person);
		
		return "day1/inputpersonpost";
	}
	
	
	@RequestMapping(value = "inputpersonpost")
	public String inputPersonGet() {
		
		return "day1/inputpersonpost";
	}
	
	@ResponseBody
	@RequestMapping(value = "inputpersonpostajax",method = RequestMethod.POST)
	public String inputPersonPostAjax(@RequestBody Person person) {
		
		System.out.println("person:" + person);
		
		return "day1/inputpersonpost";
	}
	
	


}
