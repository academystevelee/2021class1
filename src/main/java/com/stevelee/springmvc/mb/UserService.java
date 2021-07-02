package com.stevelee.springmvc.mb;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserDto selectOneUser(String id) {
		
		UserDao udao = sqlSession.getMapper(UserDao.class);
		UserDto udto = udao.selectOneUser(id);
		System.out.println(udto);
		
		return udto;
	}

}
