package com.stevelee.springmvc.day3_session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping(value = "sessiontest1")
	public String sessionTest1(HttpServletRequest request, HttpSession session) {
		
		//HttpSession session =  request.getSession();
		System.out.println("sessionid:" + session.getId());
		
		return "day3/sessiontest1";
	}
	
}
