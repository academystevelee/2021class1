package com.stevelee.springmvc.day1_data;

public enum Gender {
	male("����"),
	female("����");
	
	private String gender;

	private Gender() {
		// TODO Auto-generated constructor stub
	}
	
	private Gender(String string) {
		// TODO Auto-generated constructor stub
		this.gender = string;
	}
	
	private String getGender() {
		return this.gender;
	}

}
