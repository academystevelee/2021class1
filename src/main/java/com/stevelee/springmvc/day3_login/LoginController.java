package com.stevelee.springmvc.day3_login;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/logincookie")
	public String loginCookie() {
		
		return "day3/logincookie";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/logincookieajax")
	public boolean loginCookieAjax(HttpSession session,@RequestBody LoginDto logindto) {
		
		System.out.println(logindto);
		
		session.setAttribute(logindto.getId(),logindto);
		
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value = "/logincookiesession")
	public boolean loginCookieSession(HttpServletRequest request,HttpSession session,@RequestBody LoginDto logindto) {
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			
			System.out.println("cookie:"+cookie.getValue()); 
		
		}
		
		boolean result = false;
		
		System.out.println(logindto);
		
		session.setAttribute(logindto.getId(),logindto);
		
		LoginDto sessiondto =  (LoginDto) session.getAttribute(logindto.getId());
		
		if(sessiondto == null) System.out.println("null");
		else {
			System.out.println("not null");
			if(sessiondto.getPw().equals(logindto.getPw())) result = true;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/logincookielist")
	public String loginCookieList(
			//@CookieValue String id,@CookieValue String pw,
			HttpServletRequest request, Model model,@ModelAttribute LoginDto logindto, HttpSession session) {
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			
			System.out.println("cookie:"+cookie.getValue()); 
		
		}
		//System.out.println("cookieid:"+id);
		//System.out.println("cookiepw:"+pw);
		
		LoginDto sessiondto =  (LoginDto) session.getAttribute(logindto.getId());
		
		boolean result = false;
		
		String resulturl = "day3/logincookie";
		
		if(sessiondto == null) System.out.println("null");
		else {
			System.out.println("not null");
			if(sessiondto.getPw().equals(logindto.getPw())) {
				result = true;
				resulturl = "day3/loginpersonlistobjs";
				Enumeration<String> attlist =  session.getAttributeNames();
				ArrayList<LoginDto> logindtolist = new ArrayList<LoginDto>();
				while(attlist.hasMoreElements()) {
					String att = attlist.nextElement();
					LoginDto ldto =(LoginDto) session.getAttribute(att);
					logindtolist.add(ldto);
				}
				model.addAttribute("logindtolist", logindtolist);
				
				String json = new Gson().toJson(logindtolist);
				System.out.println("json:" + json);
				model.addAttribute("logindtolistjson", json);
			}else model.addAttribute("sessionresult", false);
		}		
		
		return resulturl;
	}
	
	
	
}
