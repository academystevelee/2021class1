package com.stevelee.springmvc.mb;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MbController {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "selectuser")
	public String selectUser (@RequestParam String id) {
		
		System.out.println("selectuser");
		UserDto udto = sqlSession.selectOne("user.selectUser");
		UserDto udto2 = sqlSession.selectOne("user.selectUserid", id);
		System.out.println("udto:" + udto);
		System.out.println("udto2:" + udto2);
		
		return "test";
	}

	@RequestMapping(value = "selectuserdao")
	public String selectUserDao (@RequestParam String id) {
		
		System.out.println("selectuserdao");
		UserDto udto = userService.selectOneUser(id);
		System.out.println("udto:" + udto);
		
		return "test";
	}
	
}
