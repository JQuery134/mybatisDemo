package com.baohuajie.cache.bean;

public class Person {
	private String num;
	private String name;
	public Person(String num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + "]";
	}

	
}

