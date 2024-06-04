package com.example.demo;

public class User{

	private String name;
	private String password;
	private String email;
	private int age;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public User(String name, String password, int age, String email){
		this.name = name;
		this.password=password;
		this.age=age;
		this.email=email;
	}

	public User(){

	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"password = '" + password + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}
