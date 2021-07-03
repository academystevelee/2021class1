package com.stevelee.springmvc.exam2;

public class UserHistoryDto extends UserDto {

	private String sessionid;
	private String logindate;
	
	
	public UserHistoryDto() {
		
	}


	public UserHistoryDto(String id, String pw, String sessionid, String logindate) {
		super(id,pw);
		this.sessionid = sessionid;
		this.logindate = logindate;
	}

	public UserHistoryDto(UserDto udto, String sessionid, String logindate) {
		super(udto.getId(),udto.getPw());
		this.sessionid = sessionid;
		this.logindate = logindate;
	}
	public UserHistoryDto(UserDto udto, String sessionid) {
		super(udto.getId(),udto.getPw());
		this.sessionid = sessionid;
	}


	public String getSessionid() {
		return sessionid;
	}


	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}


	public String getLogindate() {
		return logindate;
	}


	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}


	@Override
	public String toString() {
		return "UserHistoryDto [id=" + super.getId() + ", pw=" + super.getPw() + ", sessionid=" + sessionid + ", logindate=" + logindate
				+ "]";
	}
	

	
	
	
	
	
}
