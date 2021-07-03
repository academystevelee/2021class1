package com.stevelee.springmvc.exam2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Exam2Controller {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//insertTenUser
	@ResponseBody
	@RequestMapping(value = "/insertTenUser" , method = RequestMethod.GET)
	public boolean insertTenUser() {
		
		boolean result = false;
		
		return result;
	}

	
	//로그인 페이지
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String login() {
		
		return "exam2/login";
	}
	
	
	
	//로그인 post api
	//로그인 히스토리 insert
	//로그인 히스토리 정보 조회 화면
	
	@RequestMapping(value = "/loginaction" , method = RequestMethod.POST)
	public String loginaction(HttpServletRequest request, HttpSession session
			//, @RequestBody UserDto udto
			, @ModelAttribute UserDto udto
			, Model model) {
			
		System.out.println("loginaction in:" + udto);
		
		String returnpage = "exam2/login"	;
		
		int result = sqlSession.selectOne("exam2.loginUser", udto);
		
		if(result == 1) {
			
			UserHistoryDto uhdto = new UserHistoryDto(udto, session.getId());
			int insertresult = sqlSession.insert("exam2.insertUserHistory", uhdto);
			
			if(insertresult != 1) returnpage = "exam2/error";
			else {
				returnpage = "exam2/loginlist";
				List<UserHistoryDto> userlist  = sqlSession.selectList("exam2.selectUserHistory");
				System.out.println("userlist size:" + userlist.size());
			}
			
		}else {
			model.addAttribute("loginresult", "false");
		}
		
		return returnpage;
	}
	
		
	
	//로그인 필터 조회 화면
	
	@ResponseBody
	@RequestMapping(value = "/loginhistoryfield" , method = RequestMethod.POST )
	public Map<Object, Object> loginHistoryField () {
		
		return new HashMap<Object, Object>();
	}
	
	

}
