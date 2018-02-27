package com.wangzh.basethread;

public class User {
   public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}
	public User(){
		super();
	}
	String userName;
	int age;
	
	@Override
	public String toString(){
		return userName+"("+String.valueOf(age)+")";
	}
}
