package com.stevelee.springmvc.day1_data;

public class Person {
	
	private String name;
	private int age;
	private Gender gender ;
	
	public Person() {
		
	}
	
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		
		if("male".equals(gender)) this.gender = Gender.male;
		else this.gender = Gender.female;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	public String toString2() {
		return name + "," + age + "," + gender;
	}
	
	
	
	

}
