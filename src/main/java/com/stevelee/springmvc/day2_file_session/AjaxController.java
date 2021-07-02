package com.stevelee.springmvc.day2_file_session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping(value = "inputpost", method=RequestMethod.GET)
	public String inputPost() {
		
		return "day2/inputpost";
	}
	
	@RequestMapping(value = "inputpostform", method=RequestMethod.GET)
	public String inputPostForm(@RequestParam String name, @RequestParam String age) {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		
		
		return "day2/inputpost";
	}
	
	@ResponseBody
	@RequestMapping(value = "inputpostajaxget", method=RequestMethod.GET)
	public void inputPostAjaxGet(@RequestParam String name, @RequestParam String age) {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		
		
		//return "day2/inputpost";
	}
	
	@ResponseBody
	@RequestMapping(value = "inputpostajaxpost", method=RequestMethod.POST)
	public void inputPostAjaxPost(@RequestBody String ajaxbody) {
		System.out.println("ajaxbody:" + ajaxbody);
		
		
		//return "day2/inputpost";
	}
	
	
	
	
	
}
