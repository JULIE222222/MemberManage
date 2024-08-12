package com.member.controller;

public class Member {

	private int num;
	private String name;
	private String phone;
	private String addr;
	private String pwd;

	public Member(int num, String name, String phone, String addr, String pwd) { // 생성자 생성!
		super();
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.pwd = pwd;
	}

	public int getNum() {

		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
